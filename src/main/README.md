# Sistema de Gerenciamento de Vendas 🛒

Este é um sistema de gerenciamento de vendas desenvolvido com PostgreSQL e escrito na linguagem JAVA, para fins
didáticos. Ele possui as seguintes funcionalidades:

# Package Model 📁

## CustomerModel 👤

Atributos:

- 🆔 `private int idCustomer`: Identificador do cliente.
- 📇 `private String customerName`: Nome do cliente.
- 📧 `private String email`: Endereço de e-mail do cliente.
- 🆔 `private String cpf`: CPF do cliente.
- 🏠 `private String address`: Endereço do cliente.

## ManagerModel 👨‍💼

Atributos:

- 👤 `private String name`: Nome do gerente.
- 📧 `private String email`: Endereço de e-mail do gerente.
- 🔐 `private String password`: Senha do gerente.

## ProductModel 📦

Atributos:

- 📦 `private String productName`: Nome do produto.
- 💰 `private Double price`: Preço do produto.

## SaleModel 📈

Atributos:

- 🆔 `private int idSale`: Identificador da venda.
- 📦 `private int amount`: Quantidade vendida.
- 💲 `private double total`: Total da venda.
- 👨‍💼 `private int fk_idseller`: ID do vendedor associado.
- 👤 `private int fk_idcustomer`: ID do cliente associado.
- 📦 `private int fk_idproduct`: ID do produto associado.

## SellerModel 👩‍💼

Atributos:

- 🆔 `private int idSeller`: Identificador do vendedor.
- 👨‍💼 `private String sellerName`: Nome do vendedor.
- 📧 `private String email`: Endereço de e-mail do vendedor.
- 🆔 `private String cpf`: CPF do vendedor.
- 💰 `private double salary`: Salário do vendedor.

**Getters e Setters estão disponíveis para todos os atributos.**

# Package Repository 📁

## CustomerRepository 👤

- **`registerNewCustomer`**:
    - Função: Registra um novo cliente no banco de dados.
    - Consulta SQL: `INSERT INTO tbCustomer (name, email, cpf, address) VALUES (?, ?, ?, ?)`

- **`deleteCustomer`**:
    - Função: Deleta um cliente do banco de dados.
    - Consulta SQL: `DELETE FROM tbCustomer WHERE idcustomer = ?`

## ManagerRepository 👨‍💼

- **`registerNewManager`**:
    - Função: Registra um novo gerente no banco de dados.
    - Consulta SQL: `INSERT INTO tbManager (name, email, password) VALUES (?, ?, ?)`

- **`logIn`**:
    - Função: Realiza o login de um gerente.
    - Consulta SQL: `SELECT * FROM tbManager WHERE email = ? AND password = ?`

- **`deleteManager`**:
    - Função: Deleta um gerente do banco de dados.
    - Consulta SQL: `DELETE FROM tbManager WHERE email = ?`

- **`showAllManagers`**:
    - Função: Mostra todos os gerentes registrados.
    - Consulta SQL: `SELECT * FROM tbManager`

- **`showPeoplesWithBusinessEmail`**:
    - Função: Mostra pessoas com e-mails comerciais.
    - Consulta SQL:
      ` SELECT tbSeller.name, tbSeller.email FROM tbSeller WHERE tbSeller.email LIKE '%zup.com.br%' UNION SELECT tbCustomer.name, tbCustomer.email FROM tbCustomer WHERE tbCustomer.email LIKE '%zup.com.br%'`

## ProductRepository 📦

- **`registerNewProduct`**:
    - Função: Registra um novo produto no banco de dados.
    - Consulta SQL: `INSERT INTO tbProduct (name, price) VALUES (?, ?)`

- **`deleteProduct`**:
    - Função: Deleta um produto do banco de dados.
    - Consulta SQL: `DELETE FROM tbProduct WHERE name = ?`

- **`showAllProducts`**:
    - Função: Mostra todos os produtos registrados.
    - Consulta SQL: `SELECT * FROM tbProduct`

## SaleRepository 📈

- **`registerNewSale`**:
    - Função: Registra uma nova venda no banco de dados.
    - Consulta SQL: `INSERT INTO tbSale (amount, total, id_seller, id_customer, id_product) VALUES (?, ?, ?, ?, ?)`

- **`deleteSale`**:
    - Função: Deleta uma venda do banco de dados.
    - Consulta SQL: `DELETE FROM tbSale WHERE idsale = ?`

- **`showItemsThatHaveBeenSoldForMoreThanTen`**:
    - Função: Mostra os itens vendidos por mais de dez unidades.
    - Consulta
      SQL: `SELECT tbProduct.name, tbSale.total FROM tbProduct, tbSale WHERE tbSale.id_product = tbProduct.idProduct AND tbSale.total > 10.00`

- **`showAllSales`**:
    - Função: Mostra todas as vendas registradas.
    - Consulta SQL: `SELECT * FROM tbSale`

- **`changeTotalValueOfSalesThatAreNullToZero`**:
    - Função: Altera o valor total das vendas nulas para zero.
    - Consulta SQL: `UPDATE tbSale SET total = 0 WHERE total IS NULL`

## SellerRepository 👩‍💼

- **`registerNewSeller`**:
    - Função: Registra um novo vendedor no banco de dados.
    - Consulta SQL: `INSERT INTO tbSeller (name, email, cpf, salary) VALUES (?, ?, ?, ?)`

- **`logIn`**:
    - Função: Realiza o login de um vendedor.
    - Consulta SQL: `SELECT * FROM tbSeller WHERE email = ?`

- **`showSalespeopleSalary`**:
    - Função: Mostra o salário dos vendedores, ordenados por salário decrescente.
    - Consulta SQL: `SELECT tbseller.name, tbseller.salary FROM tbseller ORDER BY tbseller.salary DESC`

- **`deleteSeller`**:
    - Função: Deleta um vendedor do banco de dados.
    - Consulta SQL: `DELETE FROM tbseller WHERE idseller = ?`

# Package Service 📁

## Classe `ManagerUseCase` 👨‍💼

- **Extende:** `ValidationManagerInfos`

### Instâncias:

- `ManagerController managerController`: Controlador responsável pelas operações relacionadas aos gerentes.
- `ValidationProductInfos validationProductInfos`: Utilitário para validar informações de produtos.
- `ProductController productController`: Controlador responsável pelas operações relacionadas aos produtos.
- `SaleController saleController`: Controlador responsável pelas operações relacionadas às vendas.
- `SellerController sellerController`: Controlador responsável pelas operações relacionadas aos vendedores.

## Classe `SellerUseCase` 👩‍💼

- **Extende:** `ValidationSellerInfos`

### Instâncias:

- `SellerController sellerController`: Controlador responsável pelas operações relacionadas aos vendedores.
- `SaleController saleController`: Controlador responsável pelas operações relacionadas às vendas.
- `ProductController productController`: Controlador responsável pelas operações relacionadas aos produtos.
- `CustomerController customerController`: Controlador responsável pelas operações relacionadas aos clientes.

## Classe `ValidationManagerInfos` 📋

### Funções:

- `checkEmail(String emailCheck)`: Verifica se o formato do email é válido (contém "@" e ".com").
- `checkName(String nameCheck)`: Verifica se o nome não está vazio.
- `checkPassword(String passwordCheck)`: Verifica se a senha possui pelo menos 8 caracteres.

## Classe `ValidationProductInfos` 📦

### Funções:

- `checkName(String nameCheck)`: Verifica se o nome do produto não está vazio.
- `checkPrice(Double priceCheck)`: Verifica se o preço do produto é maior que zero.

## Classe `ValidationSellerInfos` 👩‍💼

### Funções:

- `checkEmail(String emailCheck)`: Verifica se o formato do email é válido (contém "@" e ".com").
- `checkName(String nameCheck)`: Verifica se o nome não está vazio.
- `checkCpf(String cpf)`: Verifica se o CPF tem mais de 11 caracteres.
- `checkSalary(Double salary)`: Verifica se o salário é maior que zero.

# Package Controller 📁

## Classe `CustomerController` 👤

### Instâncias:

- `CustomerRepository customerRepository`: Instância do repositório de clientes, que permite acessar o banco de dados para armazenar e recuperar informações dos clientes.

- `CustomerModel customerModel`: Instância do modelo de dados de cliente, que fornece a estrutura para representar informações de clientes, como nome, email, CPF e endereço.

### Funcionalidades:

- `registerNewCustomer(String name, String email, String cpf, String address)`: Registra um novo cliente.

- `deleteCustomer(int idCustomer)`: Deleta um cliente.

## Classe `ManagerController` 👨‍💼

### Instâncias:

- `ManagerRepository managerRepository`: Instância do repositório de gerentes, que permite acessar o banco de dados para armazenar e recuperar informações dos gerentes.

- `ManagerModel managerModel`: Instância do modelo de dados de gerente, que fornece a estrutura para representar informações de gerentes, como nome, email e senha.

### Funcionalidades:

- `registerNewManager(String nameController, String emailController, String passwordController)`: Registra um novo gerente.

- `logIn(String emailController, String passwordController)`: Realiza login como gerente.

- `deleteManager(String emailController)`: Deleta um gerente.

- `showAllManagers()`: Mostra todos os gerentes registrados.

- `showPeoplesWithBusinessEmail()`: Mostra pessoas com e-mails comerciais.

## Classe `ProductController` 📦

### Instâncias:

- `ProductModel productModel`: Instância do modelo de dados de produto, que fornece a estrutura para representar informações de produtos, como nome e preço.

- `ProductRepository productRepository`: Instância do repositório de produtos, que permite acessar o banco de dados para armazenar e recuperar informações dos produtos.

### Funcionalidades:

- `registerNewProduct(String nameController, Double priceController)`: Registra um novo produto.

- `deleteProduct(String nameProductController)`: Deleta um produto.

- `showAllProducts()`: Mostra todos os produtos registrados.

## Classe `SaleController` 📈

### Instâncias:

- `SaleRepository saleRepository`: Instância do repositório de vendas, que permite acessar o banco de dados para armazenar e recuperar informações das vendas.

- `SaleModel saleModel`: Instância do modelo de dados de venda, que fornece a estrutura para representar informações das vendas, como quantidade, total e identificadores de vendedor, cliente e produto.

### Funcionalidades:

- `registerNewSale(int amount, Double total, int id_seller, int id_customer, int id_product)`: Registra uma nova venda.

- `deleteSale(int idSale)`: Deleta uma venda.

- `showItemsThatHaveBeenSoldForMoreThanTen()`: Mostra itens vendidos em quantidade superior a dez unidades.

- `changeTotalValueOfSalesThatAreNullToZero()`: Altera o valor total das vendas nulas para zero.

- `showAllSales()`: Mostra todas as vendas registradas.

## Classe `SellerController` 👩‍💼

### Instâncias:

- `SellerRepository sellerRepository`: Instância do repositório de vendedores, que permite acessar o banco de dados para armazenar e recuperar informações dos vendedores.

- `SellerModel sellerModel`: Instância do modelo de dados de vendedor, que fornece a estrutura para representar informações de vendedores, como nome, email, CPF e salário.

### Funcionalidades:

- `registerNewSeller(String name, String email, String cpf, double salary)`: Registra um novo vendedor.

- `logIn(String emailController)`: Realiza login como vendedor.

- `deleteSeller(int idSeller)`: Deleta um vendedor.

- `showSalespeopleSalary()`: Mostra o salário dos vendedores.


# Package View 📁

## Classe `MainMenu` 🚀

### Função:

- `start()`: Inicia o aplicativo, solicitando que o usuário escolha entre [1] vendedor ou [2] gerente para continuar.

## Classe `ManagerView` 👨‍💼

### Instâncias:

- `static ManagerUseCase managerUseCase`: Instância da classe `ManagerUseCase`, que permite acessar as funcionalidades relacionadas ao gerente.
- `static Scanner scan`: Instância do Scanner para receber entradas do usuário.

### Funções:

- `registerManager()`: Solicita nome, email e senha para registrar um novo gerente e encaminha as informações para validação por meio do `managerUseCase`. Em seguida, direciona para a função de login.

- `logIn()`: Solicita o email e senha do gerente e encaminha as informações para validação por meio do `managerUseCase`. Após a validação, permite continuar com o aplicativo.

- `startManager()`: Apresenta as opções de [1] logar ou [2] registrar gerente com base na escolha do usuário e direciona para as funções correspondentes.

- `menuManager()`: Apresenta um menu com várias opções de ações relacionadas à gestão do sistema, como deletar gerente, ver gerentes existentes, excluir cliente, excluir vendedor, excluir produto, excluir venda, ver salários de vendedores, cadastrar produtos, mostrar emails com 'zup.com' ou sair do aplicativo.

## Classe `SellerView` 👩‍💼

### Instâncias:

- `static Scanner scan`: Instância do Scanner para receber entradas do usuário.
- `SellerUseCase sellerUseCase`: Instância da classe `SellerUseCase`, que permite acessar as funcionalidades relacionadas ao vendedor.

### Funções:

- `registerSeller()`: Solicita nome, email, CPF e salário para registrar um novo vendedor e encaminha as informações para validação por meio do `sellerUseCase`. Em seguida, direciona para a função de login.

- `logIn()`: Solicita o email do vendedor e encaminha a informação para validação por meio do `sellerUseCase`. Após a validação, permite continuar com o aplicativo.

- `startSeller()`: Apresenta as opções de [1] logar, [2] cadastrar-se ou [3] voltar ao menu principal com base na escolha do usuário e direciona para as funções correspondentes.

- `menuSeller()`: Apresenta um menu com várias opções de ações relacionadas à gestão do sistema pelo vendedor, como ver produtos, alterar valor da venda nula para 0, ver vendas acima de 10 reais, ver todas as vendas, registrar vendas, excluir venda, registrar cliente ou sair do aplicativo.
