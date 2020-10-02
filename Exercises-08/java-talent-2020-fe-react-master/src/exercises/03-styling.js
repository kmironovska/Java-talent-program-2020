import React from 'react';
import PropTypes from 'prop-types';
import './03-styling.css';
import {purple} from "color-name";
// this will use webpack to load the css styles into your app.


function Box(props) {
    return (
        // render a div with the props:
        // - className that is assigned to `Box Box--${props.size}`
        // - style that is assigned to props.style
        // inside the div, forward along props.children
        <div className={`Box Box--${props.size}`} style={props.style}>{props.children}</div>
    );
}

// I'm gonna give this one to you. Isn't that nice? :)
Box.propTypes = {
    size: PropTypes.oneOf(['small', 'medium', 'large']),
    style: PropTypes.object,
    children: PropTypes.node.isRequired
};

export const Example = () => (
    <div>
        <Box size="small" style={{'backgroundColor': 'blue'}}>This is one small box</Box>
        <Box size="medium" style={{'backgroundColor': 'green'}}>This is one medium box</Box>
        <Box size="large" style={{'backgroundColor': 'purple'}}>This is one large box</Box>

    </div>
);
