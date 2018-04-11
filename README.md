## Quick start
**Make sure you have Maven and Java 1.7 or greater**
**Make sure you also have NPM 3.1, Node 6.9.5 and angular-cli@1.0.0 globally installed**
```bash
# clone our repo
# --depth 1 removes all but one .git commit history
git clone --depth 1 https://github.com/bfwg/angular-spring-starter.git

# change directory to the repo's frontend folder
cd angular-spring-starter/frontend

# install the frontend dependencies with npm
# npm install @angular/cli@1.0.0 -g
npm install

# start the frontend app
npm start

# change directory to the repo's backend folder
cd ../server

# install the server dependencies with mvn
mvn install

# start the backend server
mvn spring-boot:run

# the fronend angular app will be running on port 4200
# the spring-boot server will be running on port 8080
```

## Deployment

```bash
# clone our repo
# --depth 1 removes all but one .git commit history
git clone --depth 1 https://github.com/bfwg/angular-spring-starter.git

# change directory to the repo's frontend folder
cd angular-spring-starter/frontend

# install the frontend dependencies with npm
# npm install @angular/cli@1.0.0 -g
npm install

# build frontend project to /server/src/main/resources/static folder
ng build

# change directory to the repo's backend folder
cd ../server

# install the server dependencies with mvn
mvn install

# start the server
mvn spring-boot:run

# the app will be running on port 8080
```