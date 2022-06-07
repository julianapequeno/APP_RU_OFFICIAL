CREATE TABLE bolsista (
nome 	text,
email	text,
cpf	text,
login	text,
senha	text,
nomecao	text
);

SELECT * FROM chefenutricionista;

CREATE TABLE cardapio (
lancheManha	text,
almoco	text,
lancheTarde	text,
janta	text,
Ceia	text,
cp	int
);

CREATE TABLE bolsista (
nome 	text,
email	text,
cpf	text,
login	text,
senha	text,
nomecao	text
);

CREATE TABLE nutricionista (
nome 	text,
email	text,
cpf	text,
login	text,
senha	text,
nomecao	text
);

CREATE TABLE chefenutricionista (
nome 	text,
email	text,
cpf	text,
login	text,
senha	text,
nomecao	text
);

SELECT login FROM chefenutricionista UNION SELECT login FROM nutricionista UNION SELECT login FROM bolsista;

SELECT senha FROM chefenutricionista UNION SELECT senha FROM nutricionista UNION SELECT senha FROM bolsista;


INSERT INTO chefenutricionista VALUES ('usuarioPrincipal','email','cpf','login','senha','chefeNutricionista');
INSERT INTO nutricionista VALUES ('Juliana','email','cpf','jujuSantiago','mysenha','Nutricionista');
INSERT INTO bolsista VALUES ('Suellen','email','cpf','suhSuh','mysenha','Nutricionista');

DROP TABLE bolsista;


CREATE TABLE acessosapp (
nome 	text,
email	text,
cpf	text,
login	text,
senha	text,
nomecao	text
);

