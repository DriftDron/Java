public class ThreadFactory implements ObjectFactory<Thread> {

    @Override
    public Thread createNew() {
        return new Thread();
    }

}
