package customAnnotate;

import java.lang.*;
import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.lang.NullPointerException;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Mysinglevalue{
	int value();
}

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
@interface Mysinglevalue2{
	int value2();
}

public class Singlevalue {
	@Mysinglevalue(value=100)
	public void printto()
	{
		System.out.println("hey this is single valued annotation 1");
	}
	@Mysinglevalue2(value2=9)
	public void printtotwo()
	{
		
		System.out.println("hey this is single valued annotation 2");
	}
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		try {
		Singlevalue sgv = new Singlevalue();
		sgv.printto();
		Method m = sgv.getClass().getMethod("printto");
		Method m2 = sgv.getClass().getMethod("printtotwo");
		Mysinglevalue sv = m.getAnnotation(Mysinglevalue.class);
		Mysinglevalue2 sv2 = m2.getAnnotation(Mysinglevalue2.class);
		System.out.println(sv.value() + " is value of annotation");
		System.out.println(sv2.value2() + " is value of annotation 2");
		
		}
		catch(NullPointerException nse)
		{
			System.out.println("Please change retention policy to RUNTIME");
		}
	}

}
