public class Term{
    int coefficient;
    int power;
    Term next;

    public Term(int coefficient, int power){
        this.coefficient= coefficient;
        this.power=power;
        this.next = null;
    } 
}