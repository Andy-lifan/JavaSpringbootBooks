document.addEventListener('DOMContentLoaded', init);

function init() {
    
    document.querySelector('#addBook > button')
        .addEventListener('click', onAdd);    
    document.querySelector('#findSingleBook > button')
        .addEventListener('click', onFindSingleBook);
    document.querySelector('#findAllBooks > button')
        .addEventListener('click', onFindAllBooks);
    document.querySelector('#removeBook > button')
        .addEventListener('click', onRemove);
    document.querySelector('#editBook > button')
        .addEventListener('click', onEdit);
}

async function onAdd() {
    let data = {
        bookId: document.querySelector('#addBook #newBookId').value,
        title: document.querySelector('#addBook #newBookTitle').value,
        authorName: document.querySelector('#addBook #newBookAuthorName').value,
        bookPages: document.querySelector('#addBook #newBookPages').value,
        datePublished: document.querySelector('#addBook #newDatePublished').value,
        dateAdded: document.querySelector('#addBook #newDateAdded').value
    };
    console.log('adding data', data);
    const response = await fetch('/books', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    await onFindAllBooks();
}

async function onFindSingleBook() {

    let id = parseInt(document.querySelector('#findSingleBook #bookId').value);
    console.log('finding bookId', id);
    let response = await fetch(`/books/${id}`);
    let json = await response.json();
    console.log('find single book', json);
    document.querySelector('#findSingleBook > .output').innerHTML = query_buildTable([json]);
}

async function onFindAllBooks() {
    let response = await fetch('/books');
    let json = await response.json();
    console.log('find all books', json);
    document.querySelector('#findAllBooks > .output').innerHTML = query_buildTable(json);
}

async function onRemove() {

    let id = parseInt(document.querySelector('#removeBook #bookId').value);
    console.log('removing bookId', id);
    const response = await fetch(`/books/${id}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        },       
    });
    await onFindAllBooks();
}

async function onEdit() {
    let data = {
        bookId: document.querySelector('#editBook #editBookId').value,
        title: document.querySelector('#editBook #editBookTitle').value,
        authorName: document.querySelector('#editBook #editBookAuthorName').value,
        bookPages: document.querySelector('#editBook #editBookPages').value,
        datePublished: document.querySelector('#editBook #editDatePublished').value,
        dateAdded: document.querySelector('#editBook #editDateAdded').value
    };
    console.log('editing data', data);
    const response = await fetch('/books/${id}', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    await onFindAllBooks();
}

function query_buildTable(records) {
    let html = `<table>`;
    html += `<thead>`;
    html += `  <tr>`;
    html += `    <th>ID</th>`;
    html += `    <th>Title</th>`;
    html += `    <th>Author</th>`;
    html += `    <th>Pages</th>`;
    html += `    <th>Published Date</th>`;
    html += `    <th>Added Date</th>`;
    html += `  </tr>`;
    html += `</thead>`;
    html += `<tbody>`;
    records.forEach(r => {
       html += `<tr>`;
       html += `  <td>${r.bookId.toString()}</td>`
        html += `  <td>${r.title}</td>`
        html += `  <td>${r.authorName}</td>`
        html += `  <td>${r.bookPages}</td>`
        html += `  <td>${r.datePublished}</td>`
        html += `  <td>${r.dateAdded}</td>`
       html += `</tr>`;
    });
    html += `</tbody>`;
    html += `</table>`;
    return html;
}