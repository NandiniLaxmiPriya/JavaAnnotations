package customAnnotate;
import java.lang.*;
import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)  
@interface sweetcontainer{
	sweet[] value();
}

@Repeatable(sweetcontainer.class)
@interface sweet{
	int count();
	String name() default "hhhh";
}

@sweet(count=1,name="jalebi")
@sweet(count=2,name="rasgulla")
public class RepeatableAnno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepeatableAnno rpa = new RepeatableAnno();
//		Class ppp = rpa.getClass();
//		Annotation an = ppp.getAnnotation(sweet.class);
//		sweet sw = (sweet)an;
//		System.out.println(sw.name());
		
		sweet[] sw = RepeatableAnno.class.getAnnotationsByType(sweet.class);
		for(sweet g:sw)
		{
			System.out.println(g.count()+" "+g.name());
		}
	}

}
