<template>
  <h3>{{ title }}</h3>
  <div>
    <input id="new-quote-text" v-model="newQuoteText" placeholder="Neuer Spruch" type="text" ref="nameInput" />
    <input v-model="newQuoteIndex" placeholder="Position" @keyup.enter="save()" />
    <button id="save-button" type="button" @click="save()">Save</button>
  </div>
  <div>
    <table>
      <thead>
        <tr>
          <th>Index</th>
          <th colspan="2">Quote</th>
        </tr>
      </thead>
      <tbody>
        <tr v-if="quotes.length === 0">
          <td colspan="2">No quotes yet</td>
        </tr>
        <tr v-for="quote in quotes" :key="quote.index">
          <td>{{ quote.index }}</td>
          <td class="w-100">
            <input
                class="w-100"
                :disabled="editQuoteIndex !== quote.index"
                v-model="quote.quote"
                :id="'edit-input-'+quote.index"
            >
          </td>
          <td class="edit-btn-wrapper">
            <button
                v-if="editQuoteIndex !== quote.index"
                @click="editQuoteIndex=quote.index"
                :disabled="editQuoteIndex !== -1"
                :id="'edit-button-'+quote.index"
            >
              Edit
            </button>

            <!--TODO hier Update-Button einfügen-->
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup>
import {ref, onMounted} from 'vue'
import axios from 'axios'

defineProps({
  title: String
})

const quotes = ref([])
const newQuoteText = ref("")
const newQuoteIndex = ref("")
const editQuoteIndex = ref(-1)

function loadQuotes() {
  const endpoint = "http://localhost:8080/api/v1/quotes";
  axios.get(endpoint)
      .then((response) => {
        quotes.value = response.data;
      });
}

function save() {
  const endpoint = "http://localhost:8080/api/v1/quote/" + newQuoteIndex.value;
  const data = {
    quote: newQuoteText.value,
    index: newQuoteIndex.value,
  };
  axios.post(endpoint, data)
    .then((data) => {
      console.log("Success:", data);
      loadQuotes();
    })
    .catch((error) => console.log("error", error));
}
// TODO hier updateQuote Methode einfügen
// TODO hier sortQuotesBy Methode einfügen

onMounted(() => {
  loadQuotes();
})
</script>

<style scoped>
.w-100 {
  width: 100%;
}
.edit-btn-wrapper {
  button {
    margin-left: 8px;
    width: 80px;
  }
}
</style>
