package core.java.reactive.programming;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.FutureTask;

@Slf4j
public class ObservablePractice {

    @Test
    public void create(){
        createObservableUsingIntegerArray();
        createObservableUsingIntegerList();
        createObservableUsingFutureTask();
    }

    private void createObservableUsingFutureTask() {
        // from
        FutureTask<List<Integer>> futureTask = new FutureTask<>(() -> {
           return  Arrays.asList(34, 55, 89);
        });
        Schedulers.computation().createWorker().schedule(futureTask::run);
        Observable<List<Integer>> observableFutureTask = Observable.fromFuture(futureTask);
        observableFutureTask.subscribe(list -> {
           list.forEach(System.out::println);
        });
    }

    private void createObservableUsingIntegerList() {
        // from list
        List<Integer> integerList = Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21);
        Observable<Integer> observableIntegerList = Observable.fromIterable(integerList);
        observableIntegerList.subscribe(System.out::println);
    }

    private void createObservableUsingIntegerArray() {
        // from array
        Integer[] integerArray = {1,2,3,4,5,6,7,8,9,10};
        Observable<Integer> observableIntegerArray = Observable.fromArray(integerArray);
        observableIntegerArray.subscribe(System.out::println);
    }

    @Test
    public void observerOnNextOnErrorOnCompletedMethodsSynchronousExecution(){
        String currentThread = Thread.currentThread().getName();
        log.info("current-thread={}", currentThread);

        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);
        integerObservable.subscribe(
            // onNext function
            (i) -> {
                log.info("onNext enter, thread-name={}", Thread.currentThread().getName());
                log.info("{}", i);
                log.info("onNext exit, thread-name={}", Thread.currentThread().getName());
            },
            // onError function
            (t) -> {
                t.printStackTrace();
            },
            // onCompleted function
            () -> {
                log.info("onCompleted() function");
            }
        );
    }

    @Test
    public void schedulersNewThread(){
        String currentThread = Thread.currentThread().getName();
        log.info("current-thread={}", currentThread);

        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);
        integerObservable.subscribeOn(Schedulers.newThread())
                .subscribe(
                        (i) -> {
                            System.out.println("onNext enter, thread-name="+ Thread.currentThread().getName());
                            System.out.println(i);
                            System.out.println("onNext exit, thread-name="+ Thread.currentThread().getName());
                        },
                        /* this code is same as below
                        (t) -> {
                            t.printStackTrace();
                        },*/
                        Throwable::printStackTrace,
                        () -> {
                            System.out.println("onCompleted()");
                        }
                );
    }

    @Test
    public void ioSchedulers(){
        String currentThread = Thread.currentThread().getName();
        log.info("current-thread={}", currentThread);

        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);
        integerObservable.subscribeOn(Schedulers.io())
                .subscribe(
                        (i) -> {
                            System.out.println("onNext enter, thread-name="+ Thread.currentThread().getName());
                            System.out.println(i);
                            System.out.println("onNext exit, thread-name="+ Thread.currentThread().getName());
                        },
                        /* this code is same as below
                        (t) -> {
                            t.printStackTrace();
                        },*/
                        Throwable::printStackTrace,
                        () -> {
                            System.out.println("onCompleted()");
                        }
                );
    }

    @Test
    public void ioSchedulersParallel(){
        String currentThread = Thread.currentThread().getName();
        log.info("current-thread={}", currentThread);

        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);
        integerObservable.subscribeOn(Schedulers.newThread())
                .subscribe(
                        (i) -> {
                            System.out.println("onNext enter, thread-name="+ Thread.currentThread().getName());
                            System.out.println(i);
                            System.out.println("onNext exit, thread-name="+ Thread.currentThread().getName());
                        },
                        /* this code is same as below
                        (t) -> {
                            t.printStackTrace();
                        },*/
                        Throwable::printStackTrace,
                        () -> {
                            System.out.println("onCompleted()");
                        }
                );
    }

    @Test
    public void composition(){
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Observable.from

    }
}
