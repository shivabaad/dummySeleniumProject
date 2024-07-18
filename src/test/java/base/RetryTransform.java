package base;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

public class RetryTransform implements org.testng.internal.annotations.IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod,
			Class<?> occurringClazz) {
		IAnnotationTransformer.super.transform(annotation, testClass, testConstructor, testMethod, occurringClazz);
		annotation.setRetryAnalyzer(Retry.class);
	}

}
