package customAnnotate;


import java.lang.*;
import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Mymultivalued{
	
	int maxMarks() default 50;
	String subject();
}

@Mymultivalued(subject="Maths")
public class Multivalued {
	int rno;
	String name;
	int marksobt;
	
	Multivalued(int rno,String name,int marksobt)
	{
		this.rno=rno;
		this.name=name;
		this.marksobt=marksobt;
	}
	
	public void printRev()
	{
		System.out.println("Rollno "+rno+" Name "+name+" Marks obtained "+marksobt);
	}
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		Multivalued mvs = new Multivalued(11,"BushyBrow",45);
		Class c = mvs.getClass();
		Annotation ano = c.getAnnotation(Mymultivalued.class);
		Mymultivalued mgs = (Mymultivalued)ano;
		System.out.println("Subject: "+mgs.subject()+" "+"Maximum Marks:"+mgs.maxMarks());
		mvs.printRev();
	}

}
