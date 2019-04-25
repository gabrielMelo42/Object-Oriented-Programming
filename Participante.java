import java.time.LocalDateTime;
import java.util.Collection;
import java.util.ArrayList;

class Participante 
{
    public String email;
    public Collection<LocalDateTime> inicioP = new ArrayList<LocalDateTime>();
    public Collection<LocalDateTime> fimP = new ArrayList<LocalDateTime>();;

    public Participante(String email) {
        this.email = email;
    }
}