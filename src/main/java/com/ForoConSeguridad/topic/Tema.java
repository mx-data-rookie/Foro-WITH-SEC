package com.ForoConSeguridad.topic;
import com.ForoConSeguridad.user.Usuario;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "temas")
@Entity(name = "Tema")
public class Tema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTema;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    private String asunto;
    private boolean asuntoActivo = true;

    @Enumerated(EnumType.STRING)
    private AsignaturaEnum asignaturaEnum;

    private String mensaje;
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    public Tema(){}

    public Tema(TemaDTO temaDTO, Usuario usuario){
        this.asunto = temaDTO.asunto();
        this.mensaje = temaDTO.mensaje();
        this.asignaturaEnum = temaDTO.asignaturaEnum();
        this.usuario = usuario;
    }

    public Long getIdTema() {
        return idTema;
    }

    public void setIdTema(Long idTema) {
        this.idTema = idTema;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public boolean isAsuntoActivo() {
        return asuntoActivo;
    }

    public void setAsuntoActivo(boolean asuntoActivo) {
        this.asuntoActivo = asuntoActivo;
    }

    public AsignaturaEnum getAsignaturaEnum() {
        return asignaturaEnum;
    }

    public void setAsignaturaEnum(AsignaturaEnum asignaturaEnum) {
        this.asignaturaEnum = asignaturaEnum;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void actualizarTema(TemaActualizadoDTO temaActualizadoDTO, Usuario usuario){
        if(temaActualizadoDTO.asunto() != null){
            this.asunto = temaActualizadoDTO.asunto();

        }

        if(temaActualizadoDTO.mensaje() != null){
            this.mensaje = temaActualizadoDTO.mensaje();
        }

        if(usuario != null){
            this.usuario = usuario;
        }
    }

    public void desactivarTema(){
        this.asuntoActivo = false;
    }
}
