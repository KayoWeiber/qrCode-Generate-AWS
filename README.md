# Gerador de QR Code com Java, Spring e AWS S3

## 📖 Descrição

Este projeto é um serviço de backend para a geração de QR Codes. A aplicação recebe um texto como entrada, gera a imagem do QR Code correspondente e a armazena em um bucket do Amazon S3, retornando a URL pública da imagem.

## ✨ Funcionalidades

* Geração de QR Codes a partir de um texto.
* Upload automático do QR Code gerado para um bucket do AWS S3.
* Retorno da URL pública para acesso à imagem do QR Code.

## 🛠️ Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3.4.4**
    * Spring Web
    * Spring Boot Dev Tools
* **Google Zxing:** Biblioteca para geração de QR Codes.
* **AWS SDK for Java:** Para integração com o serviço S3.
* **Docker:** Para a conteinerização da aplicação.
* **Amazon S3:** Para armazenamento dos QR Codes gerados.

## 🚀 Como Usar

### Pré-requisitos

* Java 21
* Maven
* Docker
* Conta na AWS com as credenciais configuradas

### Instalação e Execução

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/KayoWeiber/qrCode-Generate-AWS](https://github.com/KayoWeiber/qrCode-Generate-AWS)
    ```

2.  **Navegue até o diretório do projeto:**
    ```bash
    cd seu-repositorio
    ```

3.  **Construa a imagem Docker:**
    ```bash
    docker build -t qrcode-generator .
    ```

4.  **Execute o container Docker, passando suas credenciais da AWS e o nome do bucket como variáveis de ambiente:**
    ```bash
    docker run -p 8080:8080 \
      -e AWS_ACCESS_KEY_ID=SUA_ACCESS_KEY \
      -e AWS_SECRET_ACCESS_KEY=SUA_SECRET_KEY \
      -e AWS_S3_BUCKET=NOME_DO_SEU_BUCKET \
      qrcode-generator
    ```

### Endpoints da API

* **POST** `/qrcode/generate`

    **Request Body:**
    ```json
    {
      "text": "Seu texto aqui"
    }
    ```

    **Response:**
    ```json
    {
      "qrCodeUrl": "https://<nome-do-seu-bucket>.s3.<regiao>[.amazonaws.com/](https://.amazonaws.com/)<nome-do-arquivo>.png"
    }
    ```

