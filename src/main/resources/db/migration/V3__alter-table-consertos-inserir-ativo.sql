-- Inclui o campo para a exclusão lógica.
alter table consertos add ativo boolean;

-- Os consertos que já estavam no banco começam como ativos.
update consertos set ativo = true;
