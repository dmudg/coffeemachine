package service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import models.beverages.Beverages;
import models.ingredients.Ingredients;

public class Manager {
	private List<Beverages> beverages=null;
	private IngredientsManager im=null;
	int outlets;
	private boolean isRefilling=false;
	AtomicInteger jobsInProgress;
	public Manager(List<Beverages> beverages,IngredientsManager im,int outlets){
		this.beverages=beverages;
		this.im=im;
		this.outlets=outlets;
		this.jobsInProgress=new AtomicInteger(0);
	}
	public synchronized boolean checkSubtract(Beverages b){
		boolean flag=true;
		List<Ingredients> ingredientsRequired=b.getValue();
		for(int i=0;i<ingredientsRequired.size();i++){
			Ingredients ingredient=ingredientsRequired.get(i);
			if(im.compareIngredient(ingredient)==0){
				if(flag)
					System.out.println(b.getName()+" can not be prepared because "+ingredient.getName()+" is not sufficient");
				flag=false;
			}
			else if(im.compareIngredient(ingredient)==-1){
				if(flag)
					System.out.println(b.getName()+" can not be prepared because item "+ingredient.getName()+" is not available");
				flag=false;
			}
		}
		if(flag){
			for(int i=0;i<ingredientsRequired.size();i++){
				im.subtractIngredient(ingredientsRequired.get(i));
			}
		}
		return flag;
	}
	
	public void makeBeverage(Beverages b){		
		if(jobsInProgress.incrementAndGet()>outlets){
			System.out.println("All outlets in use");
		}	
		else if(isRefilling){
			System.out.println("Refill in progress.Cannot proceed");
		}
		else if(b!=null){
			boolean flag=checkSubtract(b);
			if(flag)
				b.serve();			
		}
		jobsInProgress.decrementAndGet();
	}
	
	public void refill(){
		if(jobsInProgress.get()>0){
			System.out.println("Cannnot refill as outlets in use");
		}else{
			isRefilling=true;
			im.refillAll();
			isRefilling=false;
		}
	}
	public void start() {
		ExecutorService executors = Executors.newFixedThreadPool(outlets);
		Collections.shuffle(this.beverages);
		List<Future<String>> futures = new ArrayList<>(outlets);
		for(int i=0;i<this.beverages.size();i++){
			Beverages b=this.beverages.get(i);
			Callable<String> callableTask = () -> {
				makeBeverage(b);
			    return "Served";
			};
			Future<String> future=executors.submit(callableTask);
			futures.add(future);
		}
		for(Future<String> future:futures){
			try {
				future.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		executors.shutdown();
	}
	
}
