# 步驟 1: 選擇一個基礎 Image
# 我們不是從零開始，而是基於一個已經安裝好 Java 17 的官方 Image (openjdk:17-jdk-slim)
# slim 版本表示這是一個輕量化的版本，可以讓我們的最終 Image 比較小
FROM openjdk:17-jdk-slim

# 步驟 2: 設定一個參數來代表我們建置好的 JAR 檔
# ARG 定義了一個變數，這裡我們讓 JAR_FILE 指向 target 資料夾下由 Maven 產生的任何 .jar 檔案
ARG JAR_FILE=target/*.jar

# 步驟 3: 複製檔案到 Image 中
# 將我們建置好的 JAR 檔複製到 Image 的根目錄下，並將它重新命名為 app.jar
# 這樣可以讓我們用一個固定的名稱來啟動它
COPY ${JAR_FILE} app.jar

# 步驟 4: 設定容器啟動時要執行的指令
# 這就是當容器啟動時，Docker 內部會執行的指令，等同於我們手動執行 java -jar app.jar
ENTRYPOINT ["java","--add-opens=java.base/java.lang=ALL-UNNAMED","-jar","/app.jar"]
