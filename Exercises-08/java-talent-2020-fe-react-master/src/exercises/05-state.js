import React from 'react';

// So far we've just been using function components.
// Now that we need to worry about state in our component, we need to use the ES6 class syntax.
// To turn an ES6 class into a React component, you extend React.Component
// (or `import {Component} from 'react'` and use that)
//
// Exercise:
//
// Our EditNote component needs to have two input fields for title and content. 
// Changes on this fields needs to be saved in the local component state and displayed on the screen.
class EditNote extends React.Component {
    constructor(props) {
        super(props);
        this.state ={
            title: '',
            content: ''
        }
    }

    ChangeNameandContent = (data) => {
        this.setState({
            [data.target.name]: data.target.value
        });
    };
    render() {
        return ( <div>
            <input type={'text'} name = 'title' value={this.state.title} onChange={this.ChangeNameandContent}/>
            <input type={'text'} name='content' value={this.state.content} onChange={this.ChangeNameandContent}/>
            <br/>
            <p><b>Title: {this.state.title}</b></p>
            <p><b>Content: {this.state.content}</b></p>
        </div>)
    }
}

export const Example = () => <EditNote />;
