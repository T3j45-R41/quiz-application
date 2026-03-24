package quiz.manager;
import java.util.*;
import quiz.model.Question;

public class QuestionManager {
    private List<Question> quesbank;

    public QuestionManager(){
        quesbank=new ArrayList<>();
    }
    public void addQues(Question q){
        for(Question ques:quesbank){
            if(ques.getquesId()==q.getquesId()){
                System.out.println("Question ID already exists!");
                return;
            }
        }
            quesbank.add(q);
            System.out.println("Question added successfully");
        }
    

    public List<Question> getAllques(){
        return new ArrayList<>(quesbank);
    }

    public Question getquesbyId(int id){
        for(Question q:quesbank){
            if(id==q.getquesId())
                return q;
        }
    return null;
    }

     public boolean deleteQues(int id){
        Iterator<Question> it=quesbank.iterator();
        
        while(it.hasNext()){
            Question temp=it.next();
            if(temp.getquesId()==id){
                it.remove();
                return true;
            }
        }
        return false;
    }

    public boolean updateQues(int id,Question newq){
        for(int i=0;i<quesbank.size();i++){
            if(quesbank.get(i).getquesId()==id){
                quesbank.set(i,newq);
                return true;
            }
        }
        return false;
    }

    public List<Question> getBydifficulty(Question.Difficulty diff){
        List<Question> res=new ArrayList<>();
        for(Question q:quesbank){
            if(q.getDifficulty()==diff)
                res.add(q);
        }
        return res;
    }

    public List<Question> getBycategory(Question.Category category){
        List<Question> res=new ArrayList<>();
        for(Question q:quesbank){
            if(q.getCategory()==category)
                res.add(q);
        }
        return res;
    }

    public List<Question> getRandom(int n){
        List<Question> random=new ArrayList<>(quesbank);

        Collections.shuffle(random);
        if(n>random.size())
            return random;
        else 
            return random.subList(0, n);
    }

    public int getTotal(){
        return quesbank.size();
    }
}
