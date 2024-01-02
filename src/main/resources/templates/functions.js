addressFunctions = {
  getAddresses: function () {
    fetch("http://localhost:8080/addresses", {
      method: "GET",
      withCredentials: true,
      crossorigin: true,
      mode: "no-cors",
      headers: {
        "Content-type": "application/json",
      },
    })
      .then((response) => {
        return response.json();
      })
      .then((data) => console.log({ data }))
      .catch((error) => {
        console.error();
      });
  },
};

personFunctions = {
  getPersons: function () {
    fetch("http://localhost:8080/persons", {
      method: "GET",
      withCredentials: true,
      crossorigin: true,
      mode: "no-cors",
      headers: {
        "Content-type": "application/json",
      },
    })
      .then((response) => {
        return response.json();
      })
      .then((data) => console.log({ data }))
      .catch((error) => {
        console.error();
      });
  },
};
