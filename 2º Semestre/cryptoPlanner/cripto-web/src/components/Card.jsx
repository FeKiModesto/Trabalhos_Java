import { icons } from '../icons';

export function Card({ title, icon, onActivityClick }) {
  const Icon = icons[icon];

  function handleClick() {
    onActivityClick(title);
  }

  return (
    <button
      onClick={handleClick}
      className="flex flex-col gap-4 items-center bg-slate-800 text-slate-100 p-6 rounded-lg w-64 shadow-md hover:shadow-xl hover:-translate-y-1 transition cursor-pointer border border-slate-700"
    >
      <Icon className="size-16 w-full text-amber-400" strokeWidth={1.5} />
      <span className="text-2xl font-medium">{title}</span>
    </button>
  );
}
