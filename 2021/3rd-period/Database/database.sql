CREATE DATABASE piggaborn;
USE piggaborn;

CREATE TABLE inventario (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE tipo_mapa (
  `id` INT AUTO_INCREMENT,
  `descricao` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE tipo_loja (
  `id` INT AUTO_INCREMENT,
  `descricao` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE raca (
  `id` INT AUTO_INCREMENT,
  `nome` VARCHAR(200) NOT NULL,
  `descricao` TEXT NOT NULL,
  `habilidade` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC) VISIBLE);
  
CREATE TABLE personagem (
  `id` INT AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `nivel` INT NOT NULL,
  `vida` INT NOT NULL,
  `estamina` INT NOT NULL,
  `magicka` INT NOT NULL,
  `exp` INT NOT NULL,
  `inventario_id` INT NOT NULL,
  `raca_id` INT NOT NULL,
  PRIMARY KEY (`id`, `inventario_id`, `raca_id`),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC) VISIBLE,
  INDEX `fk_personagem_inventario1_idx` (`inventario_id` ASC) VISIBLE,
  INDEX `fk_personagem_raca1_idx` (`raca_id` ASC) VISIBLE,
  CONSTRAINT `fk_personagem_inventario1`
    FOREIGN KEY (`inventario_id`)
    REFERENCES inventario (`id`),
  CONSTRAINT `fk_personagem_raca1`
    FOREIGN KEY (`raca_id`)
    REFERENCES raca (`id`));

CREATE TABLE mapa (
  `id` INT AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `dificuldade` INT NOT NULL,
  `tipo_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC) VISIBLE,
  CONSTRAINT `fk_mapa_tipo`
    FOREIGN KEY (`tipo_id`)
    REFERENCES tipo_mapa (`id`));
  
CREATE TABLE personagem_mapa (
  `personagem_id` INT AUTO_INCREMENT,
  `mapa_id` INT NOT NULL,
  PRIMARY KEY (`personagem_id`, `mapa_id`),
  INDEX `fk_personagem_has_mapa_mapa1_idx` (`mapa_id` ASC) VISIBLE,
  INDEX `fk_personagem_has_mapa_personagem_idx` (`personagem_id` ASC) VISIBLE,
  CONSTRAINT `fk_personagem_has_mapa_personagem`
    FOREIGN KEY (`personagem_id`)
    REFERENCES personagem (`id`),
  CONSTRAINT `fk_personagem_has_mapa_mapa1`
    FOREIGN KEY (`mapa_id`)
    REFERENCES mapa (`id`));
    
CREATE TABLE loja (
  `id` INT AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `dinheiro` INT NOT NULL,
  `tipo_id` INT NOT NULL,
  `mapa_id` INT NOT NULL,
  `inventario_id` INT NOT NULL,
  PRIMARY KEY (`id`, `mapa_id`, `inventario_id`),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC) VISIBLE,
  INDEX `fk_loja_mapa1_idx` (`mapa_id` ASC) VISIBLE,
  INDEX `fk_loja_inventario1_idx` (`inventario_id` ASC) VISIBLE,
  CONSTRAINT `fk_loja_mapa1`
    FOREIGN KEY (`mapa_id`)
    REFERENCES mapa (`id`),
  CONSTRAINT `fk_loja_inventario1`
    FOREIGN KEY (`inventario_id`)
    REFERENCES inventario (`id`),
  CONSTRAINT `fk_loja_tipo`
    FOREIGN KEY (`tipo_id`)
    REFERENCES tipo_loja (`id`));
    
CREATE TABLE item (
  `id` INT AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `peso` INT NOT NULL,
  `valor` INT NOT NULL,
  `dano` INT,
  `armor` INT,
  `descricao` TEXT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC) VISIBLE);
  
 CREATE TABLE item_inventario (
  `item_id` INT,
  `inventario_id` INT,
  PRIMARY KEY (`item_id`, `inventario_id`),
  INDEX `fk_item_has_inventario_inventario1_idx` (`inventario_id` ASC) VISIBLE,
  INDEX `fk_item_has_inventario_item1_idx` (`item_id` ASC) VISIBLE,
  CONSTRAINT `fk_item_has_inventario_item1`
    FOREIGN KEY (`item_id`)
    REFERENCES item (`id`),
  CONSTRAINT `fk_item_has_inventario_inventario1`
    FOREIGN KEY (`inventario_id`)
    REFERENCES inventario (`id`));
    
CREATE TABLE magia (
  `id` INT AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `descricao` TEXT NOT NULL,
  `dano` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC) VISIBLE);
  
CREATE TABLE personagem_magia (
  `personagem_id` INT NOT NULL,
  `magia_id` INT NOT NULL,
  PRIMARY KEY (`personagem_id`, `magia_id`),
  INDEX `fk_personagem_has_magia_magia1_idx` (`magia_id` ASC) VISIBLE,
  INDEX `fk_personagem_has_magia_personagem1_idx` (`personagem_id` ASC) VISIBLE,
  CONSTRAINT `fk_personagem_has_magia_personagem1`
    FOREIGN KEY (`personagem_id`)
    REFERENCES personagem (`id`),
  CONSTRAINT `fk_personagem_has_magia_magia1`
    FOREIGN KEY (`magia_id`)
    REFERENCES magia (`id`));

INSERT tipo_mapa(`descricao`) VALUES ('Submundo');
INSERT tipo_mapa(`descricao`) VALUES ('Montanhas Gélidas');
INSERT tipo_mapa(`descricao`) VALUES ('Floresta Élfica');

INSERT tipo_loja(`descricao`) VALUES ('Bar');
INSERT tipo_loja(`descricao`) VALUES ('Joalheria');
INSERT tipo_loja(`descricao`) VALUES ('Ferreiro');

INSERT INTO inventario (`id`, `nome`) VALUES ('1', 'Inventário loja 1');
INSERT INTO inventario (`id`, `nome`) VALUES ('2', 'Inventário loja 2');
INSERT INTO inventario (`id`, `nome`) VALUES ('3', 'Inventário loja 3');
INSERT INTO inventario (`id`, `nome`) VALUES ('4', 'Inventário personagem 1');
INSERT INTO inventario (`id`, `nome`) VALUES ('5', 'Inventário personagem 2');

INSERT INTO item (`nome`, `peso`, `valor`, `armor`, `descricao`) VALUES ('Peitoral de Ferro', '15', '50', '32', 'Peitoral forjado com ferro');
INSERT INTO item (`nome`, `peso`, `valor`, `armor`, `descricao`) VALUES ('Peitoral de Aço', '20', '75', '35', 'Peitoral forjado com aço inoxidável');
INSERT INTO item (`nome`, `peso`, `valor`, `dano`, `descricao`) VALUES ('Espada de Ferro', '5', '50', '12', 'Espada forjada com ferro');
INSERT INTO item (`nome`, `peso`, `valor`, `dano`, `descricao`) VALUES ('Espada de Aço', '8', '75', '15', 'Espada forjado com aço inoxidável');
INSERT INTO item (`nome`, `peso`, `valor`, `dano`, `descricao`) VALUES ('Espada de Madeira', '2', '10', '5', 'Espada de madeira para treino');
INSERT INTO item (`nome`, `peso`, `valor`, `armor`, `descricao`) VALUES ('Pisante Aderente', '2', '10', '1', 'Bota antiderrapante');

INSERT INTO item_inventario (`item_id`, `inventario_id`) VALUES ('1', '1');
INSERT INTO item_inventario (`item_id`, `inventario_id`) VALUES ('2', '1');
INSERT INTO item_inventario (`item_id`, `inventario_id`) VALUES ('3', '1');
INSERT INTO item_inventario (`item_id`, `inventario_id`) VALUES ('1', '4');
INSERT INTO item_inventario (`item_id`, `inventario_id`) VALUES ('2', '4');
INSERT INTO item_inventario (`item_id`, `inventario_id`) VALUES ('4', '4');
INSERT INTO item_inventario (`item_id`, `inventario_id`) VALUES ('1', '2');
INSERT INTO item_inventario (`item_id`, `inventario_id`) VALUES ('2', '2');
INSERT INTO item_inventario (`item_id`, `inventario_id`) VALUES ('3', '2');
INSERT INTO item_inventario (`item_id`, `inventario_id`) VALUES ('3', '5');

INSERT INTO mapa (`nome`, `dificuldade`, `tipo_id`) VALUES ('Oblivion', '4', 1);
INSERT INTO mapa (`nome`, `dificuldade`, `tipo_id`) VALUES ('Skyrim', '5', 2);
INSERT INTO mapa (`nome`, `dificuldade`, `tipo_id`) VALUES ('Tamriel', '1', 3);

INSERT INTO loja (`nome`, `dinheiro`, `tipo_id` ,`mapa_id`, `inventario_id`) VALUES ('Taverna do Gragas', '1200', 1, '1', '1');
INSERT INTO loja (`nome`, `dinheiro`, `tipo_id` ,`mapa_id`, `inventario_id`) VALUES ('Riverwood Trader', '700', 2, '2', '2');
INSERT INTO loja (`nome`, `dinheiro`, `tipo_id` ,`mapa_id`, `inventario_id`) VALUES ('Geovannis el brabon', '600', 3, '3', '3');

INSERT INTO magia (`nome`, `descricao`, `dano`) VALUES ('Chamas', 'Queima o inimigo com chamas ardentes', '8');
INSERT INTO magia (`nome`, `descricao`, `dano`) VALUES ('Bola de fogo', 'Queima o inimigo com poder de fogo concentrado em bolas', '22');
INSERT INTO magia (`nome`, `descricao`, `dano`) VALUES ('Tempestade de Gelo', 'Cria uma tempestade congelante', '45');

INSERT INTO raca (nome, habilidade, descricao) VALUES ('Argoniano', 'Respiração Subaquatica', 'A raça de lagartos humanoides nativos de Black Marsh, são seres esguios e rápidos, conhecidos por sua habilidade de respirar debaixo d\'água, além da resistência à doenças, ambas as habilidades provenientes de diversas gerações de Argonians que viviam nos pântanos selvagens de Black Marsh.');
INSERT INTO raca (nome, habilidade, descricao) VALUES ('Nórdico', 'Força Suprema', 'Os Nórdicos são conhecidos por sua ferocidade e lealdade em batalha, por viverem nas terras ao norte, seus corpos são mais resistentes ao frio.');
INSERT INTO raca (nome, habilidade, descricao) VALUES ('Elfo Superior', 'Magicka Destrutiva', 'Esses elfos são conhecidos por terem aptidão para todo tipo de magia, seja ela ilusão, destruição, conjuração, alteração, restauração ou até mesmo a arte de encantar objeto');

INSERT INTO personagem (`nome`, `nivel`, `vida`, `estamina`, `magicka`, `exp`, `inventario_id`, `raca_id`) VALUES ('Dovahkiin', '1', '100', '100', '100', '1', '4', '1');
INSERT INTO personagem (`nome`, `nivel`, `vida`, `estamina`, `magicka`, `exp`, `inventario_id`, `raca_id`) VALUES ('Dragonborn', '2', '100', '110', '100', '2', '5', '2');

INSERT INTO personagem_magia (`personagem_id`, `magia_id`) VALUES ('1', '1');
INSERT INTO personagem_magia (`personagem_id`, `magia_id`) VALUES ('1', '2');
INSERT INTO personagem_magia (`personagem_id`, `magia_id`) VALUES ('2', '1');
INSERT INTO personagem_magia (`personagem_id`, `magia_id`) VALUES ('2', '2');

INSERT INTO personagem_mapa (`personagem_id`, `mapa_id`) VALUES ('1', '1');
INSERT INTO personagem_mapa (`personagem_id`, `mapa_id`) VALUES ('2', '2');

#VIEWS

CREATE VIEW listar_racas AS
SELECT
	r.id,
	r.nome AS 'Nome da Raça',
    r.descricao AS 'Descrição da Raça',
    r.habilidade AS 'Habilidade Herdada'
FROM
	raca r;

# Informação a ser extraída -->	Nível dos jogadores que possuem experiência nível 1
#(isso impacta nos itens disponíveis)

SELECT
	nome,
	nivel
 FROM
	personagem
WHERE exp=1;

# Informação a ser extraída -->	Peso suportado pelo personagem

SELECT
	nome,
    FORMAT((estamina + estamina * 10/100), '') as 'Peso Suportado'
FROM
	personagem;

# Informação a ser extraída -->	Quantidade de ataques consecutivos

SELECT 
	nome,
    FORMAT((estamina * 5/100), '') as 'Ataques Consecutivos' 
FROM 
	personagem;
    
# Informação a ser extraída -->	Quantidade de itens que o personagem leva

SELECT
	p.nome,
    count(item.id) as 'Numero de Itens'
FROM 
	personagem p
    INNER JOIN inventario i ON (p.inventario_id = i.id)
    INNER JOIN item_inventario ii  ON (i.id = ii.inventario_id) 
    INNER JOIN item ON (item.id = ii.item_id);

# Informação a ser extraída -->	Magia e dano que o personagem possui

SELECT
	p.nome,
    m.nome as Magia,
    dano
FROM 
	magia m
    INNER JOIN personagem_magia pm ON (m.id = pm.magia_id)
    INNER JOIN personagem p ON (p.id = pm.personagem_id)
ORDER BY p.nome;


# Informação a ser extraída -->	Lojas e suas respectivas descrições
SELECT
	nome,
    tipo_loja.descricao
FROM
	loja
INNER JOIN
	tipo_loja ON (loja.tipo_id=tipo_loja.id);
    
# Informação a ser extraída -->	Mapas e suas respectivas descrições

SELECT
	nome,
    tipo_mapa.descricao
FROM
	mapa
INNER JOIN
	tipo_mapa ON (mapa.tipo_id=tipo_mapa.id);
    
# Informação a ser extraída -->	habilidade herdada da classe

SELECT
	p.nome as Personagem,
    r.nome as Raça,
    habilidade as Habilidade
FROM
	raca r
    INNER JOIN personagem p ON (p.raca_id = r.id);
    
# Informação a ser extraída -->	Itens disponíveis nas lojas
    SELECT
	l.nome,
    item.nome as 'Item'
FROM 
	loja l
    INNER JOIN inventario i ON (l.inventario_id = i.id)
    INNER JOIN item_inventario ii  ON (i.id = ii.inventario_id) 
    INNER JOIN item ON (item.id = ii.item_id)
ORDER BY l.nome;

# Informação a ser extraída -->	Dinheiro das lojas

SELECT
	nome,
    FORMAT(dinheiro, '') as Saldo
FROM
	loja;
    

#EXTRAS PARA A ENTREGA FINAL

# Mostrar os itens do inventario do personagem 
SELECT
	p.nome AS personagem,
    i.nome AS item,
    i.descricao,
    i.peso,
    i.valor,
    i.dano,
    i.armor
FROM
	personagem p, inventario, item_inventario ii, item i
WHERE
	p.inventario_id = inventario.id AND inventario.id = ii.inventario_id AND i.id = ii.item_id;
    
# Mostrar os itens do inventario do personagem usando JOIN
SELECT
	p.nome AS personagem,
    i.nome AS item,
    i.descricao,
    i.peso,
    i.valor,
    i.dano,
    i.armor
FROM 
	personagem p
INNER JOIN inventario ON (p.inventario_id = inventario.id)
INNER JOIN item_inventario ii  ON (inventario.id = ii.inventario_id) 
INNER JOIN item i ON (i.id = ii.item_id);

# Selecionar o nome de todos os itens que não estão associados a nenhum inventario
SELECT
	i.nome
FROM 
	item i
WHERE NOT EXISTS
	(SELECT
		*
	FROM
		inventario, item_inventario ii
	WHERE
		inventario.id = ii.inventario_id AND i.id = ii.item_id);