import { createRouter, createWebHistory } from "vue-router";
import AboutChuck from "../views/AboutChuck.vue";
import AdminConsole from "../views/AdminConsole.vue";

const routes = [
  {
    path: "/",
    name: "AboutChuck",
    component: AboutChuck,
  },
  {
    path: "/admin",
    name: "AdminConsole",
    component: AdminConsole,
  },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

export default router;
