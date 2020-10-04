import React, { Component } from 'react';
import './style07.css';
// For controlled components, the idea is that you push the values from the component
// to the consumer via callback handlers. In the context of a form, this is normally
// via `onChange` which receives the `event` (and you can get the value via
// `event.target.value`) like so:
//
//     <input onChange={event => console.log(event.target.value)} />
//
// In this scenario, you also need to provide the value for the input like so:
//
//     <input value={this.state.value} />
//
// This gives you a lot more power over the input. 

// Exercise:
//   Render a EditNote form with an onSubmit handler that alerts the value of both title and content
//   while saving their data in the local component state
//   The submit button needs to be disabled if there is an error.
//   Error message needs to be displayed when: 
//     - The title is empty - "Title is a mandatory field"
//     - The content is empty - "Content is a mandatory field"
//     - The title contains more than 10 characters - "Title cannot contain more than 10 characters"
//   Since this is a EditNote functionality, we need to make sure to display the 'Default Title' and 'Default Content'

//   when our component is rendered.


class EditNoteForm extends Component {

    constructor(props){
        super(props);
        this.state = {
            title: props.defaultTitle,
            content: props.defaultContent,
            errorTitle: true,
            errorContent: true,
            errorMessageTitle:"",
            errorMessageContent:""

        }
    }
    onSubmit = s => {
        s.preventDefault();
        alert(`The title is : ${this.state.title} and the content is: ${this.state.content}`);

    };

    onChangeTitle = t =>{
        if(t.target.value === ""){
            this.setState({
                title: t.target.value,
                errorMessageTitle: 'Title is a mandatory field',
                errorTitle: true
            })
        }else if(t.target.value.length > 10 ){
            this.setState({
                title: t.target.value,
                errorMessageTitle: 'Title cannot contain more than 10 characters',
                errorTitle : true
            })
        }else{
            this.setState({
                title: t.target.value,
                errorMessageTitle: '',
                errorTitle: false
            })
        }
    }

    onChangeContent = c =>{
        if(c.target.value === ""){
            this.setState({
                content: c.target.value,
                errorMessageContent: 'Content is a mandatory field',
                errorContent : true
            })
        }else{
            this.setState({
                content: c.target.value,
                errorMessageContent: '',
                errorContent: false
            })
        }
    }
    render() {
        return <div>
            <h2>Edit Note Form</h2>
            <form onSubmit={this.onSubmit}>
                <input type="text" label ="title" value={this.state.title} onChange={this.onChangeTitle}/>
                <br/>
                <label>{this.state.errorMessageTitle}</label>
                <br/>
                <input type="text" label ="content" value={this.state.content}  onChange={this.onChangeContent}/>
                <br/>
                <label>{this.state.errorMessageContent}</label>
                <button disabled={this.state.errorTitle || this.state.errorContent} type="submit"><b>Submit</b></button>
            </form>
        </div>
    }
}

export const Example = () => <EditNoteForm defaultTitle="Default title" defaultContent="Default Content" />;
