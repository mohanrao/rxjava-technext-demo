package rxjavademo.basics2;

import rx.Observable;
import rx.functions.Action1;

public class ObservableCreation {
	public static void main(String[] args) {
		Observable<Integer> observable = Observable.just(1);
		observable.subscribe(new Action1<Integer>() {
			public void call(Integer t1) {
				System.out.println(t1);
				
			};
		});
		
		Observable<Integer> anotherObservable = Observable.from(1,2,3,4,5,6);
		
		anotherObservable.
			subscribe(value -> System.out.println(Thread.currentThread().getName() + value));
		
		
		
		
	}
}
