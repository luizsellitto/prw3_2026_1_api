
-- Novo campo "cor" do veículo (não obrigatório, então pode ficar null).
-- Não mexe na V1! Mudança no banco vira uma migration nova.

alter table consertos add cor varchar(50);
