
-- Tabela de consertos.
-- Os dados do mecânico e do veículo ficam aqui mesmo (são @Embedded),
-- então não tem tabela separada pra eles.
-- Nomes com underline (data_entrada), nada de camelCase no banco!

create table consertos(

    id bigint not null auto_increment,

    data_entrada varchar(10),
    data_saida varchar(10),

    -- mecânico responsável
    nome varchar(100) not null,
    anos_experiencia int,

    -- veículo
    marca varchar(100) not null,
    modelo varchar(100) not null,
    ano varchar(4) not null,

    primary key(id)

);
