## Repositório I #template #mapas #excessões
## Para que fazer mil vezes a mesma coisa se eu posso fazer uma só?
![](figura.jpg)

Vamos implementar um repositório genérico para guardar coisas.

## Funcionalidades

### Ações Administrativas

- Cadastrar alunos, professores e disciplinas.
    - alunos tem matricula(chave única), curso e nome.
    - professores tem nome, siape e nível
    - disciplinas tem codigo, curso e nome

```bash
#__begin__
$addAlu 0023 ES rui almeida
$addAlu 0021 RC bia barbosa
$addAlu 0024 EC eva galdino
$addAlu 0020 SI may parkerr

$addPro 1323 david sena
$addPro 1312 elvis caio
$addPro 1542 josue luno
$addPro 2542 almir bico

$addDis QXD01 estrutura de dados
$addDis QXD02 fundamentos de programação
$addDis QXD03 banco de dados

$getAlu 0021
0021:RC:bia barbosa
$getPro 1542
1542:josue luno
$getDis QXD03
QXD03:banco de dados

# mostre ordenado pela chave
$showAlu
0020:SI:may parkerr
0021:RC:bia barbosa
0023:ES:rui almeida
0024:EC:eva galdino

$showPro
1312:elvis caio
1323:david sena
1542:josue luno
2542:almir bico

$showDis
QXD01:estrutura de dados
QXD02:fundamentos de programação
QXD03:banco de dados

$rmAlu 0020
$rmPro 1542
$rmDis QXD02

$showAlu
0021:RC:bia barbosa
0023:ES:rui almeida
0024:EC:eva galdino

$showPro
1312:elvis caio
1323:david sena
2542:almir bico

$showDis
QXD01:estrutura de dados
QXD03:banco de dados

# erros
$addAlu 0023 mia balike
fail: aluno 0023 ja existe
$addPro 1312 ari toleto
fail: professor 1312 ja existe
$addDis QXD01 fundamentos da enrolacao
fail: disciplina QXD01 ja existe

$rmAlu 8888
fail: aluno 8888 nao existe
$rmPro 9999
fail: professor 9999 nao existe
$rmDis QXD04
fail: disciplina QXD04 nao existe

$getAlu 8888
fail: aluno 8888 nao existe
$getPro 9999
fail: professor 9999 nao existe
$getDis QXD04
fail: disciplina QXD04 nao existe

$showAlu
0021:RC:bia barbosa
0023:ES:rui almeida
0024:EC:eva galdino

$showPro
1312:elvis caio
1323:david sena
2542:almir bico

$showDis
QXD01:estrutura de dados
QXD03:banco de dados

$end
#__end__
```