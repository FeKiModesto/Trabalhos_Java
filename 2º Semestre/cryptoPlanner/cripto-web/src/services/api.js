const API_URL = 'http://localhost:8080/api/planner';

export const apiService = {
  getPlanner(activity) {
    return fetch(`${API_URL}?activity=${encodeURIComponent(activity)}`).then(
      (response) => {
        if (!response.ok) {
          throw new Error('Erro ao consultar o planner.');
        }
        return response.json();
      },
    );
  },
};
