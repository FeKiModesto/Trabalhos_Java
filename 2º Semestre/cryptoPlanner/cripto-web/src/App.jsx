import { useState } from 'react';
import { Wallet } from 'lucide-react';
import { Card } from './components/Card';
import { apiService } from './services/api';

const CARDS = [
  { title: 'Comprar Bitcoin', icon: 'bitcoin' },
  { title: 'Vender Ethereum', icon: 'coins' },
  { title: 'Investir em Dogecoin', icon: 'dog' },
];

function App() {
  const [plannerResponse, setPlannerResponse] = useState('');

  function handleCardClick(activity) {
    setPlannerResponse(`Consultando o planner para: ${activity}`);

    apiService
      .getPlanner(activity)
      .then((response) => setPlannerResponse(response.result))
      .catch(() =>
        setPlannerResponse('Erro ao consultar o planner. Verifique a API.'),
      );
  }

  return (
    <main className="min-h-screen bg-slate-900 p-8">
      <div className="max-w-4xl mx-auto">
        <div className="flex items-center gap-3">
          <Wallet className="size-10 text-amber-400" />
          <h2 className="text-5xl font-bold text-slate-100">Cripto Planner</h2>
        </div>
        <p className="text-lg mt-2 text-slate-400">
          Descubra se é um bom momento para comprar, vender ou investir em
          cripto.
        </p>

        <section className="flex flex-wrap gap-6 mt-8">
          {CARDS.map((card) => (
            <Card
              key={card.title}
              title={card.title}
              icon={card.icon}
              onActivityClick={handleCardClick}
            />
          ))}
        </section>

        {plannerResponse && (
          <section className="mt-8 p-4 rounded-lg bg-slate-800 border border-slate-700">
            <p className="text-slate-100">{plannerResponse}</p>
          </section>
        )}
      </div>
    </main>
  );
}

export default App;
