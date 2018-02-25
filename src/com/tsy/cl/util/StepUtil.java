package com.tsy.cl.util;

public class StepUtil {
	public int[] getStep(int current , int step , int pagetnum){
		if(pagetnum<step){
			return new int[]{1,pagetnum};
		}
		if(current<=(step/2)){
			return new int[]{1,step};
		}else if((pagetnum-current)<(step/2)){
			return new int[]{pagetnum-step+1,pagetnum};
		}else{
			return new int[]{current-(step/2),current+(step/2) };
		}
		
	}
}
