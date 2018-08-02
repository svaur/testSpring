import javax.annotation.PostConstruct;

public class TerminaterQouter implements Quoter {
    @IngectRandInt(min=2,max=10)
    private int repeat;
    private String message;

    @PostConstruct
    public void init(){
        System.out.println("Phase2");
        System.out.println(repeat);
    }
    public TerminaterQouter() {
        System.out.println("Phase1");
        System.out.println(repeat);
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public void sayQuote() {

        for (int i=0;i<repeat;i++) {
            System.out.println(message);
        }
    }
}
