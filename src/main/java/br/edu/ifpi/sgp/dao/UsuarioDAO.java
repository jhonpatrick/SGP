package br.edu.ifpi.sgp.dao;

import java.util.List;

import br.edu.ifpi.sgp.model.Usuario;

public interface UsuarioDAO {
	
	public void adicionarUsuario (Usuario usuario);
	
	public void excluirUsuario (Usuario usuario);
	
	public boolean alterarUsuario (Usuario usuario);
	
	public Usuario buscarUsuarioPorId (long idUsuario);
	
	public Usuario buscarUsuarioNomeSenha(String nomeUsuario, String senha);
	
    public List<Usuario> listaUsuario();
    
    public List<Usuario> pesquisarUsuario(String nome);
    
    public Long contador();
}