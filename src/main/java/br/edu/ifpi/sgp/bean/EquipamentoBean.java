/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.sgp.bean;

import br.edu.ifpi.sgp.dao.EquipamentoDAO;
import br.edu.ifpi.sgp.dao.EquipamentoDAOImpl;
import br.edu.ifpi.sgp.model.Equipamento;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Visitante
 */
@Named(value = "equipamentoBean")
@SessionScoped
public class EquipamentoBean implements Serializable {

    /**
     * Creates a new instance of EquipamentoBean
     */
    public EquipamentoBean() {
    }

    private static final long serialVersionUID = 1L;

    private EquipamentoDAO equipamentoDAO;
    private List<Equipamento> listaDeEquipamentos;
    private String nome;
    private Boolean disponibilidade;

    @PostConstruct
    public void inicializaDAO() {
        this.equipamentoDAO = new EquipamentoDAOImpl();
        this.listaDeEquipamentos = equipamentoDAO.listarEquipamentos();
    }

    public String removerEquipamento() {
        try {
            Equipamento equipamento = new Equipamento();
            equipamento.setIdEquipamento(Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("equipamento")));
            this.equipamentoDAO.removerEquipamento(equipamento);
            this.listaDeEquipamentos.remove(equipamento);
            FacesContext.getCurrentInstance().addMessage("equipamentoRemoverForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "Objeto removido com sucesso!", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("equipamentoRemoverForm", new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao remover objeto!", e.toString()));
        } finally {
            return "cadastrarEquipamento";
        }
    }

    public String adicionarEquipamento() {
        try {
            if (nome.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage("equipamentoForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "O objeto não pode ser nulo!", ""));
            } else {
                Equipamento e = new Equipamento();
                e.setNome(nome);
                e.setDisponivel(disponibilidade);
                this.equipamentoDAO.adicionarEquipamento(e);
                this.listaDeEquipamentos.add(e);
                FacesContext.getCurrentInstance().addMessage("equipamentoForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "Objeto adicionado com sucesso!", ""));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("equipamentoForm", new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao adicionar objeto!", e.toString()));
        } finally {
            return "cadastrarEquipamento";
        }
    }

    public List<Equipamento> listarEquipamentos() {
        return this.listaDeEquipamentos;
    }

    public List<Equipamento> getListaDeEquipamentos() {
        if (listaDeEquipamentos == null) {
            this.listaDeEquipamentos = listarEquipamentos();
        }
        return listaDeEquipamentos;
    }

    public void setListaDeEquipamentos(List<Equipamento> listaDeEquipamentos) {
        this.listaDeEquipamentos = listaDeEquipamentos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
