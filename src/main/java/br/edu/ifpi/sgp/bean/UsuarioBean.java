/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.sgp.bean;

import br.edu.ifpi.sgp.dao.UsuarioDAO;
import br.edu.ifpi.sgp.dao.UsuarioDAOImpl;
import br.edu.ifpi.sgp.model.entity.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Visitante
 */
@Named(value = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {

    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
    }

    private static final long serialVersionUID = 1L;

    private String email, siape, nome;
    private UsuarioDAO usuarioDAOImpl = new UsuarioDAOImpl();
    private Usuario usuario;

    @PostConstruct
    public void inicializaDAO() {
        this.usuarioDAOImpl = new UsuarioDAOImpl();
    }

    // metodos
    public String adicionarUsuario() {
        try {
            if (getEmail().isEmpty() || getSiape().isEmpty()) {
                FacesContext.getCurrentInstance().addMessage("usuarioForm",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Campos Inválidos", ""));
            } else {
                Usuario usuario = new Usuario();
                usuario.setNome(getNome());
                usuario.setEmail(getEmail());
                usuario.setSiape(getSiape());
                usuario.setStatus(true);
                // bucar por Siape antes de cadastrar novo
                this.usuarioDAOImpl.adicionarUsuario(usuario);
                FacesContext.getCurrentInstance().addMessage("usuarioForm",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário cadastrado com sucesso!", ""));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("usuarioForm",
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro ao cadastrar usuario", e.getMessage()));
        } finally {
            return "cadastrarUsuario";
        }
    }

    /**
     * Método faz login do usuário
     */
    public String fazerLogin() {
        try {
            // verificando se é o primero usuario
            // verifica qnt de usuario do sistema, caso não tenha, é criado um
            // aqui com dados da session
            Long count = usuarioDAOImpl.contador(); // retorna o numero de
            // linhas da coluna
            if (count == 0) {
                adicionarUsuario();
                FacesContext.getCurrentInstance().addMessage("usuarioForm",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Login com sucesso!", ""));
                return "paginaPrincipal";
            } else if (count > 0) {
                usuario = usuarioDAOImpl.buscarUsuarioNomeSenha(getEmail(), getSiape());
                if (usuario == null) {
                    FacesContext.getCurrentInstance().addMessage("usuarioForm",
                            new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário não encontrado!", "Login Inválido"));
                    return null;
                } else {
                    FacesContext.getCurrentInstance().addMessage("usuarioForm",
                            new FacesMessage(FacesMessage.SEVERITY_INFO, "Login com sucesso!", ""));
                    return "paginaPrincipal";
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("usuarioForm",
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário não encontrado!", e.toString()));
            System.out.println("Exception  -> " + e.toString());
            return null;
        }
    }

    /**
     * faz logout do Usuário
     */
    public String fazerLogout() {
        return "fazerLogout";
    }

    public String editarUsuario() {
        return "";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
