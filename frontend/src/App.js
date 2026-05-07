import React, { useState } from 'react';
import './App.css';

function App() {
  const [message, setMessage] = useState('');
  const [response, setResponse] = useState('');
  const [loading, setLoading] = useState(false);

  const handleChat = async () => {
    setLoading(true);
    try {
      const res = await fetch('http://localhost:8080/api/health/chat', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${localStorage.getItem('token')}`
        },
        body: JSON.stringify({ message })
      });
      const data = await res.json();
      setResponse(data.response);
    } catch (error) {
      console.error('Error:', error);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="App">
      <header className="App-header">
        <h1>AI Health Assistant</h1>
        <div className="chat-container">
          <textarea
            placeholder="Ask your health question..."
            value={message}
            onChange={(e) => setMessage(e.target.value)}
            rows={4}
          />
          <button onClick={handleChat} disabled={loading}>
            {loading ? 'Asking...' : 'Ask AI'}
          </button>
          {response && (
            <div className="response">
              <h3>AI Response:</h3>
              <p>{response}</p>
            </div>
          )}
        </div>
      </header>
    </div>
  );
}

export default App;
