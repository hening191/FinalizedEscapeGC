package com.zkteco.biometric;

public class FinalizeEscapeGC {

	public static FinalizeEscapeGC saveSelf = null;
	
	public static void isAliveOrDead(){
		if(saveSelf != null){
			System.out.println("I'm alive");
		}else{
			System.out.println("I'm dead");
		}
	}
	
	protected void finalize()throws Throwable{
		super.finalize();
		System.out.println("finalized is executed");
		saveSelf = this;
	}
	
	public static void main(String[] args) throws InterruptedException {
		saveSelf = new FinalizeEscapeGC();
		saveSelf = null;
		System.gc();
		Thread.sleep(500);
		isAliveOrDead();
		saveSelf = null;
		System.gc();
		Thread.sleep(500);
		isAliveOrDead();
	}

}
