import java.io.*;

class A {
	public void abc() throws IOException, NullPointerException, ArithmeticException, UserException {
		int a=50;
		for(int i=0;i<=20;i++) {
			System.out.println(i);
			int res= a/(a-i);
			
			if(i==150) {
				throw new NullPointerException();
			}
			if(i==120) {
				throw new IOException();
			}
			if(i==100) {
				return;
			}
			if(i==80) {
				throw new UserException("when i is 8");
			}
			if(i==60) {
				throw new UserException("when i is 6");
			}
		}
	}
	
	public void xyz()  throws IOException, NullPointerException, ArithmeticException, UserException {
		abc();
	}
	
	public void atoz()  throws IOException, NullPointerException, ArithmeticException, UserException {
		xyz();
	}
	
}

public class UserExceptionDemo {
	public static void main(String args[]) {
		try {
			A a1= new A();
			a1.atoz();
		}
		catch(IOException e) {
			System.out.println("IO exception handler");
		}
		catch(NullPointerException e) {
			System.out.println("Null pointer exception");
		}
		catch(UserException e) {
			System.out.println("Custom exception handler");
			e.printStackTrace();
			e.display();
			System.out.println("Reason: "+e.getMessage());
		}
		catch(Exception e) {
			System.out.println("Normal exception class");
		}
		finally {
			System.out.println("Thanks");
		}
		System.out.println("Program continues!");
	}
}

class UserException extends Exception {
	public UserException() {
		
	}
	
	public UserException(String msg) {
		super(msg);
	}
	
	public void display() {
		System.out.println("Just for demo");
	}
}