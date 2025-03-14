public class Polynomial{
    private Term head;

    public Polynomial(){
        this.head = null;
    }

    public void addTerm(int coefficient, int power){

        if( coefficient == 0 ){
            return;
        }

        Term term = new Term(coefficient, power);

        if( head==null || head.power<power ){
            term.next=head;
            head = term;
        }
        else{
            Term currenTerm= head; 
            Term prevTerm = null;

            while(currenTerm != null && currenTerm.power>power){
                prevTerm = currenTerm;
                currenTerm = currenTerm.next;
            }

            if(currenTerm != null && currenTerm.power == power){
                currenTerm.coefficient = currenTerm.coefficient + coefficient;

                if(currenTerm.coefficient == 0){
                    if(prevTerm != null){
                        prevTerm.next = currenTerm.next;
                    }
                    else{
                        head = currenTerm.next;
                    }
                }
            }
            else{
                term.next = currenTerm;
                if(prevTerm != null){
                    prevTerm.next= term;
                }
            }
        }
    }

    public Polynomial add(Polynomial other){

        Polynomial result = new Polynomial();
        Term p1 = this.head;
        Term p2= other.head;

        while((p1!=null || p2!= null)){
            if(p1==null){
                result.addTerm(p2.coefficient, p2.power);
                p2=p2.next;
            }

            else if(p2==null){
                result.addTerm(p1.coefficient, p1.power);
                p1= p1.next;
            }

            else if(p1.power > p2.power){
                result.addTerm(p1.coefficient, p1.power);
                p1=p1.next;
            }
            else if(p1.power < p2.power){
                result.addTerm(p2.coefficient, p2.power);
                p2=p2.next;
            }

            else{
                result.addTerm(p1.coefficient + p2.coefficient, p1.power);
                p1=p1.next;
                p2=p2.next;
            }

        }

        return result;
    }

    public int evaluate(int x){
        int result =0;
        Term current = head;
        while(current!=null){
            result = result + (int)(current.coefficient * Math.pow(x, current.power));
            current = current.next;
        }

        return  result;
    }

    @Override
    public String toString(){
        if(head==null){
            return "0";
        }
        StringBuilder sb = new StringBuilder();

        Term current = head;

        while(current!=null){
            if(sb.length()>0 && current.coefficient>0){
                sb.append(" + ");
            }
            if(current.coefficient<0){
                sb.append(" - ");
            }

            sb.append(Math.abs(current.coefficient));
            if(current.power>0){
                sb.append("x^").append(current.power);
                current = current.next;
            }
        }
        return sb.toString();
    }
}

