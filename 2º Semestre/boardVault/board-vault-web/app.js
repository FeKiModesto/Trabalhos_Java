const API_BASE = "http://localhost:8080/boardgames";

const grid = document.getElementById("grid");
const statusEl = document.getElementById("status");
const modalOverlay = document.getElementById("modal-overlay");
const modalContent = document.getElementById("modal-content");
const modalClose = document.getElementById("modal-close");

const COVER_EMOJIS = ["🎲", "♟️", "🃏", "🏰", "🐉", "🚀", "🧩", "⚔️"];
const COVER_GRADIENTS = [
  "linear-gradient(135deg,#ff4d94,#ff9a56)",
  "linear-gradient(135deg,#7c5cff,#43e6c4)",
  "linear-gradient(135deg,#ff9a56,#ffd166)",
  "linear-gradient(135deg,#43e6c4,#7c5cff)",
];

function coverStyleFor(id) {
  const gradient = COVER_GRADIENTS[id % COVER_GRADIENTS.length];
  const emoji = COVER_EMOJIS[id % COVER_EMOJIS.length];
  return { gradient, emoji };
}

function renderGrid(games) {
  grid.innerHTML = "";
  games.forEach((game) => {
    const { gradient, emoji } = coverStyleFor(game.id);

    const card = document.createElement("article");
    card.className = "card";
    card.addEventListener("click", () => openDetail(game.id));

    card.innerHTML = `
      <div class="card-cover" style="background:${gradient}">${emoji}</div>
      <div class="card-body">
        <p class="card-title">${game.title}</p>
        <p class="card-players">${game.minPlayers}-${game.maxPlayers} jogadores</p>
        <span class="card-rating">⭐ ${Number(game.rating).toFixed(1)}</span>
      </div>
    `;

    grid.appendChild(card);
  });
}

async function loadGames() {
  statusEl.textContent = "Carregando jogos...";
  statusEl.classList.remove("error");
  try {
    const response = await fetch(API_BASE);
    if (!response.ok) throw new Error("Falha ao buscar jogos");
    const games = await response.json();
    renderGrid(games);
    statusEl.textContent = `${games.length} jogo(s) encontrado(s)`;
  } catch (err) {
    statusEl.textContent =
      "Não foi possível conectar à API em " + API_BASE + ". Verifique se o back-end está rodando.";
    statusEl.classList.add("error");
  }
}

async function openDetail(id) {
  try {
    const response = await fetch(`${API_BASE}/${id}`);
    if (!response.ok) throw new Error("Jogo não encontrado");
    const game = await response.json();
    const { gradient, emoji } = coverStyleFor(game.id);

    modalContent.innerHTML = `
      <div class="modal-cover" style="background:${gradient}">${emoji}</div>
      <h2>${game.title}</h2>
      <p>${game.minPlayers}-${game.maxPlayers} jogadores</p>
      <p>⭐ ${Number(game.rating).toFixed(1)} / 5.0</p>
    `;
    modalOverlay.classList.remove("hidden");
  } catch (err) {
    alert("Não foi possível carregar os detalhes deste jogo.");
  }
}

modalClose.addEventListener("click", () => modalOverlay.classList.add("hidden"));
modalOverlay.addEventListener("click", (e) => {
  if (e.target === modalOverlay) modalOverlay.classList.add("hidden");
});

loadGames();
