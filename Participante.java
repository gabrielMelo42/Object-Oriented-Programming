import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

class Participante 
{
    public String email;
    public List<LocalDateTime> inicioP = new ArrayList<LocalDateTime>();
    public List<LocalDateTime> fimP = new ArrayList<LocalDateTime>();;

    public Participante(String email) {
        this.email = email;
    }
}