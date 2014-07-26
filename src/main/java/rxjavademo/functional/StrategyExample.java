package rxjavademo.functional;

import java.util.function.Function;

public class StrategyExample {
    public static Integer count = 0;
	public static void main(String[] args) {
		Displayer displayer = new Displayer(
			
			
			( value) -> 
				 value.toUpperCase()
			
		);
		
		displayer.display("heLLo");
		
		Displayer smallCaseDisplayer = new Displayer(value -> value.toLowerCase());
		smallCaseDisplayer.display("heLLo");
		
		Displayer anotherDisplayer = new Displayer(Displayer :: applying);
		anotherDisplayer.display("heLLo");
		
		Function<String, String> variable = (value) -> value.toString();
		
		
		
	}
	
	public static Integer square(Integer value) {
		return value * value;
	}
	
	public static Integer getSquareAndAddCount(Integer value){
		return value * value + count;
	}
	
}

class Displayer {
  private ApplicationStrategy strategy;
  public Displayer(ApplicationStrategy strategy){
	  this.strategy = strategy;
  }
  
  public void display(String value){
	  System.out.println(strategy.apply(value));
  }
  
  public static String applying(String value) {
	  return value.concat("Converted").toLowerCase();
  }
  
  public static Function<String, String> returnMe(){
	  return (value) -> value.toLowerCase();
  }
}



interface ApplicationStrategy{
	public String apply(String value);
}
