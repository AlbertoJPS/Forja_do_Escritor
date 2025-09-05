# Estágio 1: O "Builder" - Constrói a aplicação usando o JDK completo
FROM eclipse-temurin:17-jdk-jammy as builder
WORKDIR /app

# Copia somente os arquivos de configuração do Maven e baixa as dependências
# Isso otimiza o cache do Docker
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

# Copia o código-fonte e constrói o .jar
COPY src ./src
RUN ./mvnw package -DskipTests

# Estágio 2: A Imagem Final - Usa apenas o JRE, que é menor e mais seguro
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copia apenas o .jar final do estágio "builder"
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta que a aplicação usa
EXPOSE 8080

# Comando para iniciar a aplicação quando o contêiner for executado
ENTRYPOINT ["java", "-jar", "app.jar"]