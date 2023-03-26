package homework3;

import java.util.Random;

public class Homework {

	public static void main(String[] args) {
		Queue numberqueue = new Queue(1000);
		Queue numberqueue2 = new Queue(1000);		
		Queue tempqueue= new Queue(1000);
		Queue tempqueue2= new Queue(1000);
		Queue q1 = new Queue(1000);
		Queue q2 = new Queue(1000);
		Queue bag1 = new Queue(1000);
		Queue tempbag1 = new Queue(1000);
		Queue bag2 = new Queue(1000);
		
		for(int i =1;i<18;i++) {
			bag1.enqueue(i);
		}
					
		Random rnd = new Random();	
		//rastgele sayý
		int o =0;
		while(o<7) {
			boolean flag = true;
			int a = rnd.nextInt(17)+1;
			tempqueue.enqueue(a);
			for(int i =0;i<tempqueue.size()-1;i++) {				
				if(a == (int)tempqueue.peek()) {					
					flag= false;
					break;
				}
				tempqueue.enqueue(tempqueue.dequeue());
			}						
			if(flag == true) {
				numberqueue.enqueue(a);
				o++;
			}
		}
		
		int p =0;
		while(p<7) {
			boolean flag = true;
			int a = rnd.nextInt(17)+1;
			tempqueue2.enqueue(a);
			for(int i =0;i<tempqueue2.size()-1;i++) {				
				if(a == (int)tempqueue2.peek()) {					
					flag= false;
					break;
				}
				tempqueue2.enqueue(tempqueue2.dequeue());
			}						
			if(flag == true) {
				numberqueue2.enqueue(a);
				p++;
			}
		}			
		int u=7;
		int r =7;
		int z = 17;
		int counter =0;
		int counter2 =0;
		int award = 0;
		int award2 = 0;
		boolean flagg = true;
		
		
		while(flagg){			
			boolean flag = true;
			int a = rnd.nextInt(17)+1;
			tempbag1.enqueue(a);
			for(int i =0;i<tempbag1.size()-1;i++) {				
				if(a == (int)tempbag1.peek()) {					
					flag= false;
					break;
				}
				tempbag1.enqueue(tempbag1.dequeue());
			}
			if(flag == true) {	
				
				System.out.print("Player 1: ");
				for(int l =0;l<u;l++) {
					System.out.print(numberqueue.peek() + " ");
					numberqueue.enqueue(numberqueue.dequeue());
				}
				System.out.println();
				System.out.print("Player 2: ");
				for(int l =0;l<r;l++) {
					System.out.print(numberqueue2.peek() + " ");
					numberqueue2.enqueue(numberqueue2.dequeue());					
				}
				System.out.print("                       Bag1: ");
				for(int l =0;l<z;l++) {					
					System.out.print(bag1.peek() + " ");
					bag1.enqueue(bag1.dequeue());					
				}
				System.out.println();
				System.out.print("Selected number: " + a +"                                Bag2: ");				
				for(int l =0;l<bag2.size();l++) {
					System.out.print(bag2.peek() + " ");
					bag2.enqueue(bag2.dequeue());					
				}
				System.out.println();
				System.out.print("\n");
				int numbersize= numberqueue.size();
				for(int y =0;y<numbersize;y++) {
					if(a == (int)numberqueue.peek()) {
						numberqueue.dequeue();
						u--;
						counter++;
						if(counter == 4) {
							System.out.println("Player1 gets $10 (Birinci Çinko) ");
							award +=10;
						}
						else if(counter == 7) {
							award+=30;
						}
						break;
					}
					else {
						numberqueue.enqueue(numberqueue.dequeue());
					}					
				}
				int numbersize2= numberqueue2.size();
				for(int y =0;y<numbersize2;y++) {
					if(a == (int)numberqueue2.peek()) {
						numberqueue2.dequeue();
						counter2++;
						r--;
						if(counter2 == 4) {
							System.out.println("Player2 gets $10 (Birinci Çinko) ");
							award2 +=10;
						}
						else if(counter2 == 7) {							
							award2+=30;
						}
						break;
					}
					else {
						numberqueue2.enqueue(numberqueue2.dequeue());
					}					
				}
				for(int y =0;y<bag1.size();y++) {
					if(a == (int)bag1.peek()) {
						bag1.dequeue();
						z--;
						break;
					}
					else {
						bag1.enqueue(bag1.dequeue());
					}					
				}				
				bag2.enqueue(a);	
				
				if(numberqueue2.isEmpty() || numberqueue.isEmpty()) {
					flagg=false;					
				}
			}		
		} 	
		if(award==40 && award2==40) {
			System.out.println("Player1 and Player2 are the winner !!!");			
		}
		else if(award2==40) {
			System.out.println("Player2 is the winner !!!");
		}
		else if(award==40) {
			System.out.println("Player1 is the winner !!!");
		}
		System.out.println();
		System.out.println("Player1 gets $" + award);
		System.out.println("Player2 gets $" + award2);
	}

}
