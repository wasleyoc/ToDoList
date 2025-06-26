# 📝 ToDoList - Aplicação de Lista de Tarefas

Uma aplicação desktop de lista de tarefas desenvolvida em Java com interface gráfica Swing. Simples, intuitiva e eficiente para organizar suas tarefas diárias.
<img width="540" alt="Screenshot 2025-06-26 at 20 33 14" src="https://github.com/user-attachments/assets/5c5db244-c3c2-48b0-b901-eaf903cee688" />


## ✨ Funcionalidades

- ✅ **Adicionar tarefas**: Crie novas tarefas com facilidade
- ✏️ **Editar tarefas**: Clique em qualquer tarefa para editá-la
- ☑️ **Marcar como concluída**: Use o checkbox para riscar tarefas concluídas
- 🗑️ **Deletar tarefas**: Remova tarefas com o botão "x"
- 📜 **Scroll automático**: Interface suporta muitas tarefas com scroll
- 🎨 **Interface moderna**: Design limpo com fonte personalizada

## 🖼️ Interface

A aplicação possui uma interface intuitiva com:

- **Banner superior** com o título da aplicação
- **Área de tarefas** com scroll automático
- **Botão "Add Task"** para criar novas tarefas
- **Componentes de tarefa** com checkbox, campo de texto e botão de exclusão

## 🚀 Como executar

### Pré-requisitos

- Java 8 ou superior instalado
- JDK (Java Development Kit) para compilação

### Opção 1: Executar arquivos compilados

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/ToDoList.git
cd ToDoList

# Execute a aplicação (usando os arquivos já compilados)
java -cp bin App
```

### Opção 2: Compilar e executar

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/ToDoList.git
cd ToDoList

# Compile os arquivos Java
javac -d bin src/*.java

# Execute a aplicação
java -cp bin App
```

## 🏗️ Estrutura do Projeto

```
ToDoList/
├── src/                          # Código fonte
│   ├── App.java                 # Classe principal
│   ├── ToDoListGui.java         # Interface gráfica principal
│   ├── TaskComponent.java       # Componente individual de tarefa
│   ├── CommonConstants.java     # Constantes do projeto
│   └── resources/               # Recursos
│       └── LEMONMILK-Light.otf  # Fonte personalizada
├── bin/                         # Arquivos compilados
│   ├── *.class                 # Classes compiladas
│   └── resources/              # Recursos copiados
└── README.md                   # Este arquivo
```

## 🔧 Arquitetura

### Classes principais:

- **`App.java`**: Ponto de entrada da aplicação
- **`ToDoListGui.java`**: Interface principal da aplicação, gerencia a janela e componentes
- **`TaskComponent.java`**: Representa cada tarefa individual com seus controles
- **`CommonConstants.java`**: Define constantes de layout e dimensões

### Características técnicas:

- **Swing**: Framework para interface gráfica
- **Layout Manager**: BoxLayout para organização vertical das tarefas
- **Event Handling**: ActionListener para interações do usuário
- **Font Loading**: Carregamento de fonte personalizada
- **Focus Management**: Destaque visual para tarefa em edição

## 🎨 Funcionalidades em Detalhes

https://github.com/user-attachments/assets/9df254b3-199a-474e-a530-370a60fadf79


### Adicionar Tarefas

- Clique no botão "Add Task" na parte inferior
- Uma nova tarefa aparecerá com o campo de texto focado
- Digite o conteúdo da sua tarefa

### Marcar como Concluída

- Use o checkbox à esquerda de cada tarefa
- O texto ficará riscado quando marcado como concluído
- Desmarque para voltar ao estado normal

### Editar Tarefas

- Clique no campo de texto de qualquer tarefa
- O campo ficará destacado em branco durante a edição
- Suporte a formatação HTML básica

### Deletar Tarefas

- Clique no botão "x" à direita de cada tarefa
- A tarefa será removida imediatamente

## 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem de programação
- **Swing**: Framework para interface gráfica
- **AWT**: Classes para gerenciamento de eventos e layout
- **HTML**: Para formatação de texto nas tarefas

## 🎯 Melhorias Futuras

- [ ] Persistência de dados (salvar tarefas em arquivo)
- [ ] Categorização de tarefas
- [ ] Filtros (mostrar apenas concluídas/pendentes)
- [ ] Prazo para tarefas
- [ ] Notificações
- [ ] Temas personalizáveis
- [ ] Atalhos de teclado

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 🤝 Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para:

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/MinhaFeature`)
3. Commit suas mudanças (`git commit -m 'Adiciona MinhaFeature'`)
4. Push para a branch (`git push origin feature/MinhaFeature`)
5. Abra um Pull Request

## 👨‍💻 Autor

**Wasley Carvalho**

- GitHub: [@wasleycarvalho](https://github.com/wasleycarvalho)

---

⭐ Se este projeto te ajudou, não esqueça de dar uma estrela!
