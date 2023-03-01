package customAnnotate;
import java.lang.*;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@interface Mymarker{}

@Mymarker
public class Marker {
	public void Helloo()
	{
		System.out.println("my marker annotation");
	}
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		Marker mkr = new Marker();
		mkr.Helloo();
		Method mjm = mkr.getClass().getMethod("Helloo");
		Mymarker mkm = mjm.getAnnotation(Mymarker.class);
		System.out.println(mkm);
	}

}
