import java.time.LocalDateTime;

class Participante 
{
    public String email;
    public LocalDateTime inicioP;
    public LocalDateTime fimP;

    public Participante(String email) {
        this.email = email;
    }
}