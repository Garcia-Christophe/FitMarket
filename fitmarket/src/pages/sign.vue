<template>
  <v-app>
    <NavBar color="#D7473F" />

    <v-main>
      <v-container class="fill-height" fluid>
        <v-row justify="center" align-content="center">
          <v-col cols="12" sm="8" md="8">
            <v-card class="elevation-12">
              <v-window v-model="step">

                <!-- Fenêtre Connexion -->
                <v-window-item :value="1">
                  <v-row>
                    <v-col cols="12" md="8" style="padding-top: 100px; padding-bottom: 100px">
                      <v-card-text style="display: flex; flex-direction: column; gap: 20px">
                        <!-- Connexion -->
                        <p style="text-align: center; font-size: xxx-large; line-height: normal">Se connecter à
                          <strong>FitMarket</strong>
                        </p>
                        <v-row style="justify-content: center; margin: 20px;">
                          <v-btn density="compact" size="x-large" icon="mdi mdi-facebook"
                            style="margin: 0 10px; background-color: #1877F2; color: white"></v-btn>
                          <v-btn density="compact" size="x-large" icon="mdi mdi-google-plus"
                            style="margin: 0 10px; background-color: #db4a39; color: white"></v-btn>
                          <v-btn density="compact" size="x-large" icon="mdi mdi-linkedin"
                            style="margin: 0 10px; background-color: #0e76a8; color: white"></v-btn>
                        </v-row>

                        <!-- Formulaire -->
                        <div style="display: flex; flex-direction: column; gap: 20px;">
                          <p style="text-align: center">Saisissez votre email et votre mot de passe
                            pour vous connecter
                          </p>
                          <v-form>
                            <v-text-field v-model="signInUser.email" label="Adresse email" name="email"
                              prepend-icon="mdi-email" type="email" color="#D7473F" />
                            <v-text-field v-model="signInUser.password" label="Mot de passe" name="password"
                              prepend-icon="mdi-lock" type="password" color="#D7473F" />
                          </v-form>
                        </div>

                        <!-- Bouton Se connecter -->
                        <div style="display: flex; flex-direction: column; width: 25%; margin: auto">
                          <v-btn rounded color="#D7473F" @click="signIn">SE CONNECTER</v-btn>
                        </div>
                      </v-card-text>
                    </v-col>

                    <!-- Goto Inscription -->
                    <v-col cols="12" md="4"
                      style="padding-top: 100px; padding-bottom: 100px; background: linear-gradient(to right, #D56F97, #D7473F)">
                      <v-card-text
                        style="display: flex; flex-direction: column; gap: 50px; height: 100%; justify-content: center; color: white;">
                        <p style="text-align: center; font-size: xx-large; line-height: normal">Bonjour, Champion&nbsp;!
                        </p>
                        <p class="text-center">Apprenons à se connaître et commence ton aventure de
                          sportif/sportive avec nous !</p>
                        <v-btn rounded outlined style="width: 80%; margin: 0 auto" @click="step++">S'INSCRIRE</v-btn>
                      </v-card-text>
                    </v-col>
                  </v-row>
                </v-window-item>

                <!-- Fenêtre Inscription -->
                <v-window-item :value="2">
                  <v-row>
                    <!-- Goto Inscription -->
                    <v-col cols="12" md="4"
                      style="padding-top: 100px; padding-bottom: 100px; background: linear-gradient(to left, #D56F97, #D7473F)">
                      <v-card-text
                        style="display: flex; flex-direction: column; gap: 50px; height: 100%; justify-content: center; color: white;">
                        <p style="text-align: center; font-size: xx-large; line-height: normal">Heureux de te
                          revoir&nbsp;!
                        </p>
                        <p class="text-center">Connecte-toi pour accéder à ton panier, mettre des commentaires et bien
                          plus encore !</p>
                        <v-btn rounded outlined style="width: 80%; margin: 0 auto" @click="step--">SE CONNECTER</v-btn>
                      </v-card-text>
                    </v-col>

                    <v-col cols="12" md="8" style="padding-top: 100px; padding-bottom: 100px">
                      <v-card-text style="display: flex; flex-direction: column; gap: 20px">
                        <!-- Inscription -->
                        <p style="text-align: center; font-size: xxx-large; line-height: normal">Créer un compte
                          <strong>FitMarket</strong>
                        </p>
                        <v-row style="justify-content: center; margin: 20px;">
                          <v-btn density="compact" size="x-large" icon="mdi mdi-facebook"
                            style="margin: 0 10px; background-color: #1877F2; color: white"></v-btn>
                          <v-btn density="compact" size="x-large" icon="mdi mdi-google-plus"
                            style="margin: 0 10px; background-color: #db4a39; color: white"></v-btn>
                          <v-btn density="compact" size="x-large" icon="mdi mdi-linkedin"
                            style="margin: 0 10px; background-color: #0e76a8; color: white"></v-btn>
                        </v-row>

                        <!-- Formulaire -->
                        <div style="display: flex; flex-direction: column; gap: 20px;">
                          <p style="text-align: center">Saisissez votre email et votre mot de passe
                            pour vous connecter
                          </p>
                          <v-form style="display: flex; flex-direction: column; gap: 20px">
                            <v-row style="display: flex; gap: 20px">
                              <v-text-field label="Nom" name="nom" prepend-icon="mdi-card-account-details" type="text"
                                color="#D7473F" />
                              <v-text-field label="Prénom" name="prenom" prepend-icon="mdi-card-account-details"
                                type="text" color="#D7473F" />
                            </v-row>
                            <v-row style="display: flex; gap: 20px">
                              <v-text-field label="Adresse email" name="email" prepend-icon="mdi-email" type="email"
                                color="#D7473F" />
                              <v-text-field label="Mot de passe" name="password" prepend-icon="mdi-lock" type="password"
                                color="#D7473F" />
                            </v-row>
                          </v-form>
                        </div>

                        <!-- Bouton S'inscrire -->
                        <div style="display: flex; flex-direction: column; width: 25%; margin: auto">
                          <v-btn rounded color="#D7473F" @click="signUp">S'INSCRIRE</v-btn>
                        </div>
                      </v-card-text>
                    </v-col>
                  </v-row>
                </v-window-item>
              </v-window>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script setup>
import { ref } from 'vue';
import NavBar from '@/components/NavBar.vue'

const step = ref(1);
const signInUser = ref({
  email: null,
  password: null,
})

async function signIn() {
  const result = await (await fetch('http://localhost:8080/api/v1/sign/in', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      "email": "john.smith@email.com",
      "password": "motdepasse1"
    })
  })).json()
  console.log(result);
}

async function signUp() {
  // 
}
</script>