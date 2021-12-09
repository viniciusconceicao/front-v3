<span align="center"> 
	
![logo](/documentacao/img-logo/logo-search-developer.png)

## SearchDevelopers
#### Pesquisa e Inovação - 3º ADS A - Grupo 3

Um projeto que visa solucionar as necessidades tecnológicas de pessoas e empresas.

</span>

## 1. Links de documentação

* [Planner](https://tasks.office.com/bandtec.com.br/pt-BR/Home/Planner/#/plantaskboard?groupId=9166e8ae-fb9d-40a2-9584-66ed34f5b1d9&planId=ii_EMZMyhkyvS5FG1Ml182QACid3)
* [Prototipos Figma](https://www.figma.com/file/Cnz5reedIe0COnY9RKDqTe/Prototipo-searchDevelopers?node-id=0%3A1)
* [Desenho de solução Figma](https://www.figma.com/file/xTzzaOykpOnOuNj1lraa6R/Ideias-Logo-%3CsearchDeveloper%2F%3E?node-id=0%3A1)
* [Regra de Negócio](https://docs.google.com/document/d/1P2lRv8DaQ-GDhP-L5rg0hHRuaZWWFhVbOX3FTIgcDlU/edit)
* [Mapa de Empatia](https://miro.com/welcomeonboard/Yo0qY48tTP7cZXyFqJgtgW88z34QXdbQPEJuJMxMlOTE6BxAGgvXUEqZHhknUJ2E)
* [Diagrama de Classes](https://lucid.app/lucidchart/invitations/accept/80461771-b709-41b1-b867-0fb23463d7f6)
* [Apresentação Canva](https://www.canva.com/design/DAEXznIQb34/share/preview?token=Q1fOmIgNF0eXFKr1GTzgTg&role=EDITOR&utm_content=DAEXznIQb34&utm_campaign=designshare&utm_medium=link&utm_source=sharebutton)
* [Timeline](https://time.graphics/line/190c5d580b3ee609b36f79c3ab835b49)
* [Documentação Endpoints - http://localhost:8080/swagger-ui/index.html?url=/v3/api-docs](http://localhost:8080/swagger-ui/index.html?url=/v3/api-docs)

## 2. Configurando ambiente

#### 2.1 Tecnologias usadas
* HTML e CSS
* JavaScript
	* Node Js
	* React Js
		* Styled components
		* Material UI
		* Proptypes
* Java

#### 2.2 Executando a aplicação React (local)

:warning:*. É necessário o npm ou yarn para executar o projeto: use o comando "npm --version" ou "yarn --version" no terminal para saber se há uma versão instalada em sua máquina.*

Com um terminal, clone o repositório e entre no diretorio raíz. Após isso, execute os seguintes comandos:

Instale as dependências:
```
npm install
```

Execute o projeto:
```
npm start
```
Aguarde a exibição da index.

## 3. Dicas para o Desenvolvimento

### 3.1 React

#### - 3.1.1 Material UI 

O Material UI é uma lib React que possui diversos componentes prontos para utilização, o que nos permite otimizar nosso trabalho na criação de telas. Para usufruir desta lib, [entre na documentação do Material UI](https://material-ui.com/pt/) e escolha o componente que deseja utilizar, após isso, importe-o e use-o no retorno da função em seu arquivo JS.

Ex:
```

import Button from '@material-ui/core/Button';

function App() {
  return (
    <Button variant="contained" color="primary">
      Clique em mim
    </Button>
  );
}

```

#### - 3.1.2 Styled Components

O Styled Components é uma lib que nos possibilita criar CSS dentro de um arquivo JS, e também aplicar lógicas javascript no próprio código CSS. Dois dos benefícios são centralizar nosso código e auxiliar na componentização de nossos elementos. Para utiliza-lo, basta importar a lib e criar uma constate com o nome da tag definido no retorno.
Ex:
```

import styled from 'styled-components';

export function Button() {

    return (
        <>
            <BasicButton />
        </>
    )
}

const BasicButton = styled.button `
font-size: 16px;
background-color: #000;
color: #fff;
border: none;
padding: 10px 30px;
cursor: pointer; 
display: block;
`

```
Para mais informações, [acesse a documentação do Styled Components](https://styled-components.com/). :pushpin:



 
