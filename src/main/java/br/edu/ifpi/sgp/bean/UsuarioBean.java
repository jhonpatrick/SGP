/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.sgp.bean;

import br.edu.ifpi.sgp.dao.UsuarioDAO;
import br.edu.ifpi.sgp.dao.UsuarioDAOImpl;
import br.edu.ifpi.sgp.model.Usuario;
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

    private String email, nome, senha;
    private UsuarioDAO usuarioDAOImpl = new UsuarioDAOImpl();
    private Usuario usuario;

    @PostConstruct
    public void inicializaDAO() {
        this.usuarioDAOImpl = new UsuarioDAOImpl();
    }

    // metodos
    public String adicionarUsuario() {
        try {
            if (getEmail().isEmpty() || getSenha().isEmpty()) {
                FacesContext.getCurrentInstance().addMessage("usuarioForm",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Campos Inválidos", ""));
            } else {
                Usuario usuario = new Usuario();
                usuario.setNome(getNome());
                usuario.setEmail(getEmail());
                usuario.setSenha(getSenha());
                usuario.setStatus(true);
                // bucar por Siape antes de cadastrar novo
                this.usuarioDAOImpl.adicionarUsuario(usuario);
                FacesContext.getCurrentInstance().addMessage("usuarioForm",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário cadastrado com sucesso!", ""));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("usuarioForm",
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro ao cadastrar usuario", e.getMessage()));
        }
        return "cadastrarUsuario";
    }

    /**
     * Método faz login do usuário
     *
     * @return
     */
    public String fazerLogin() {
        try {
            // busnca usuario no banco
            usuario = usuarioDAOImpl.buscarUsuarioNomeSenha(getEmail(), getSenha());
            if (usuario != null) {
                FacesContext.getCurrentInstance().addMessage("usuarioForm",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Login com sucesso!", ""));
                return "paginaPrincipal";
            } else {
                FacesContext.getCurrentInstance().addMessage("usuarioForm",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário não encontrado!", "Tente novamente!"));
                return "index";
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("usuarioForm",
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário não encontrado!", "Login Inválido"));
            System.out.println("Exception  -> " + e.toString());
            return "index";
        }
    }

    /**
     * faz logout do Usuário
     *
     * @return
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
