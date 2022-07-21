public class SingletonPlayGame {
	
	private static volatile SingletonPlayGame game;
	
	private SingletonPlayGame() {
		if(game != null) {
			throw new RuntimeException("Please use getgame method");
		}
		
	}

	public static SingletonPlayGame getGame() {
		
		if(game == null) {
			synchronized (SingletonPlayGame.class) {
				if(game == null) {
					game = new SingletonPlayGame();
					countdown();
				}
			}
		}
		return game;
	}
	
	public static void countdown() {

		for(int i = 10; i >= 0; i--) {
			System.out.println("Remaining time: " + i);
			try {
			Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==0) {
				System.out.println("Your time is up.. Thank you for participating");
			}
		}
	}
	
	
		
}